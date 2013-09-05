DESCRIPTION = "Texas Instruments DSP BIOS."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

PROVIDES = "ti-dsplib"

PR = "r1"
TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"

PACKAGES = "${PN} ${PN}-dev"
FILES_${PN}-dev = "${INSTALL_DIR}"

inherit pkgconfig

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

SRC_URI = "\
           file://dsplib_c64Px_${TI_PV}_Linux.bin \
           file://ti_license.txt \
          "

S = "${WORKDIR}"

INSTALL_DIR = "${libdir}/ti-tools/dsplib_c64x+"
INHIBIT_PACKAGE_STRIP = "1"

# Nothing to compile
do_compile() {
    :
}

do_install() {
    DISPLAY="" ./dsplib_c64Px_${TI_PV}_Linux.bin --mode silent --prefix "${D}${INSTALL_DIR}"
    rm -f "${D}${INSTALL_DIR}/uninstall"
}
