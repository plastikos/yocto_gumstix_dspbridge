DESCRIPTION = "Texas Instruments DSP BIOS."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

PROVIDES = "ti-dsplib"

DEPENDS = "ti-cgt6x-native"

PR = "r1"
TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"

PACKAGES = "${PN} ${PN}-dev"
FILES_${PN}-dev = "${INSTALL_DIR}"

inherit native

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

SRC_URI = "\
           file://dsplib_c64Px_${TI_PV}_Linux.bin \
           file://ti_license.txt \
          "

SRC_URI[md5sum] = "9a6a94a48d2098174ec2d31de399ef34"

S = "${WORKDIR}"

INSTALL_DIR = "${libdir}/ti-tools/dsplib_c64x+-${PV}"
INHIBIT_PACKAGE_STRIP = "1"

# Nothing to compile
do_compile() {
    :
}

do_install() {
    env -u DISPLAY ./dsplib_c64Px_${TI_PV}_Linux.bin --mode silent --prefix "${D}${INSTALL_DIR}"
    rm -f "${D}${INSTALL_DIR}/uninstall"
}
