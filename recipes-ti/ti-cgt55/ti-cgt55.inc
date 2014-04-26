DESCRIPTION = "Texas Instruments Code Generation Tool gen 5."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

DEPENDS = "ti-xdctools-cross"

TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"
TI_PKG = "xdctools_setuplinux_${TI_PV}.bin"

SRC_URI = "\
           file://ti_cgt_c5500_${PV}_setup_linux_x86.bin \
           file://ti_license.txt \
          "

inherit cross

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

S = "${WORKDIR}"

INSTALL_DIR = "${TI_DEPOT_DIR}"

PACAKGES = "${PN}"
FILES_${PN} = "${INSTALL_DIR}/*"

# Nothing to compile
do_compile() {
    :
}

do_install() {
    chmod 755 ./ti_cgt_c5500_${PV}_setup_linux_x86.bin
    env -u DISPLAY ./ti_cgt_c5500_${PV}_setup_linux_x86.bin --mode silent --prefix "${D}${INSTALL_DIR}/cgt55-${PV}"
    find "${D}${INSTALL_DIR}" -type d -print0 | xargs -0 chmod 755
    chmod 755 "${D}${INSTALL_DIR}"/*/bin/*
}

do_populate_sysroot() {
    if [ "populate_sysroot" = "${BB_CURRENTTASK}" -o "populate_sysroot_setscene" = "${BB_CURRENTTASK}" ]; then
        # Ensure that ${INSTALL_DIR} gets put where it will be found
        mkdir -p "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}"
        tar -C "${D}" -cf - . | tar -C "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}" -xf -
    fi
}
