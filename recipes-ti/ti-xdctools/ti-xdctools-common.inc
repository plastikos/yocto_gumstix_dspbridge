DESCRIPTION = "Texas Instruments XDC (eXpanDed C) Tools."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"
TI_PKG = "xdctools_setuplinux_${TI_PV}.bin"

inherit native

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

SRC_URI = "\
           file://${TI_PKG} \
           file://ti_license.txt \
          "

S = "${WORKDIR}"

INSTALL_DIR = "${TI_DEPOT_DIR}"

PACAKGES = "${PN}"
FILES_${PN} = "${INSTALL_DIR}/*"

# Nothing to compile
do_compile() {
    :
}

do_install() {
    chmod a+x ./${TI_PKG}
    env -u DISPLAY ./${TI_PKG} ${XTRACT_ARGS} --prefix "${D}${INSTALL_DIR}"
}

do_populate_sysroot() {
    if [ "populate_sysroot" = "${BB_CURRENTTASK}" -o "populate_sysroot_setscene" = "${BB_CURRENTTASK}" ]; then
        # Ensure that ${INSTALL_DIR} gets put where it will be found
        mkdir -p "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}"
        tar -C "${D}" -cf - . | tar -C "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}" -xf -
    fi
}
