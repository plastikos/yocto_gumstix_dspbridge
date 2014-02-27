DESCRIPTION = "Texas Instruments DSP BIOS."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

PROVIDES = "ti-dsplib"

DEPENDS = "ti-cgt6x-cross"

PR = "r1"
TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"

PACKAGES = "${PN} ${PN}-dev"
FILES_${PN}-dev = "${INSTALL_DIR}"

inherit cross

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

SRC_URI = "\
           file://dsplib_c64Px_${TI_PV}_Linux.bin \
           file://ti_license.txt \
          "

SRC_URI[md5sum] = "9a6a94a48d2098174ec2d31de399ef34"

S = "${WORKDIR}"

TI_TOOLS_DIR = "${TI_DEPOT_DIR}"
INSTALL_DIR = "${TI_TOOLS_DIR}/dsplib_c64x+-${PV}"
INHIBIT_PACKAGE_STRIP = "1"


# Nothing to compile
do_compile() {
    :
}


do_install() {
    env -u DISPLAY ./dsplib_c64Px_${TI_PV}_Linux.bin --mode silent --prefix "${D}${INSTALL_DIR}"
    rm -f "${D}${INSTALL_DIR}/uninstall"
}


do_populate_sysroot() {
    if [ "populate_sysroot" = "${BB_CURRENTTASK}" -o "populate_sysroot_setscene" = "${BB_CURRENTTASK}" ]; then
        # Ensure that ${INSTALL_DIR} gets put where it will be found
        mkdir -p "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}"
        tar -C "${D}" -cf - . | tar -C "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}" -xf -
    fi
}
