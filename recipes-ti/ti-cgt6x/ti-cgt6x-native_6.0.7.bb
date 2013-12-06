DESCRIPTION = "Texas Instruments Code Generation Tool gen 6."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

PR = "r1"

inherit native

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

SRC_URI = "\
           file://ti_cgt_c6000_${PV}_setup_linux_x86.bin \
           file://ti_license.txt \
          "

SRC_URI[md5sum] = "a4ff6ebf4f76547b44544e660c1c888e"

S = "${WORKDIR}"

INSTALL_DIR = "/opt/ti-tools"

PACAKGES = "${PN}"
FILES_${PN} = "${INSTALL_DIR}/*"

# Nothing to compile
do_compile() {
    :
}

do_install() {
    DISPLAY="" ./ti_cgt_c6000_${PV}_setup_linux_x86.bin --mode silent --prefix "${D}${INSTALL_DIR}/cgt6x-${PV}"
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
