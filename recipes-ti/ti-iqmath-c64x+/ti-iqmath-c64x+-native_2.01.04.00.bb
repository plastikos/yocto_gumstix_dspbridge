DESCRIPTION = "Texas Instruments IQ Mathe fixed point math."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

PROVIDES = "ti-iqmath"

DEPENDS = "ti-cgt6x-native"
#DEPENDS += "tcl-native tk-native"

PR = "r1"
TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"

PACKAGES = "${PN} ${PN}-dev"
FILES_${PN}-dev = "${INSTALL_DIR}"

inherit native

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

BIN_INSTALLER = "c64xplus-iqmath_${TI_PV}_Linux-x86_Setup.bin"

SRC_URI = "\
           file://${BIN_INSTALLER} \
           file://ti_license.txt \
          "

SRC_URI[md5sum] = "541fbb81627f0cc6c7eaa357dfaf7b24"

S = "${WORKDIR}"

INSTALL_DIR = "${libdir}/ti-tools/iqmath_c64x+-${PV}"
INHIBIT_PACKAGE_STRIP = "1"
PSEUDO_DISABLED = "1"

# Nothing to compile
do_compile() {
    :
}

do_install() {
    mkdir -p "${D}${INSTALL_DIR}"
    chmod 755 "${BIN_INSTALLER}"
    echo Y | env -u DISPLAY "./${BIN_INSTALLER}" --mode console --prefix "${D}${INSTALL_DIR}"
}
