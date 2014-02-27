DESCRIPTION = "Texas Instruments XDAIS."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

DEPENDS = "ti-cgt6x-cross"

PR = "r0"
TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"
XDAIS_NAME = "xdais_${TI_PV}"

PACKAGES = "${PN} ${PN}-dev"
FILES_${PN}-dev = "${INSTALL_DIR}"

inherit cross

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

SRC_URI = "\
           file://${XDAIS_NAME}.tar.gz;unpack=False;md5sum=33dea671988fa63123f667fd6c0c435d \
           file://ti_license.txt \
          "

S = "${WORKDIR}"


TI_TOOLS_DIR = "${TI_DEPOT_DIR}"
INSTALL_DIR = "${TI_TOOLS_DIR}/${XDAIS_NAME}"
INHIBIT_PACKAGE_STRIP = "1"


# Nothing to compile
do_compile() {
    :
}


do_install() {
    mkdir -p "${D}${TI_TOOLS_DIR}"
    tar -C "${D}${TI_TOOLS_DIR}" -x -f "./${XDAIS_NAME}.tar.gz"
}


do_populate_sysroot() {
    if [ "populate_sysroot" = "${BB_CURRENTTASK}" -o "populate_sysroot_setscene" = "${BB_CURRENTTASK}" ]; then
        # Ensure that ${INSTALL_DIR} gets put where it will be found
        mkdir -p "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}"
        tar -C "${D}" -cf - . | tar -C "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}" -xf -
    fi
}
