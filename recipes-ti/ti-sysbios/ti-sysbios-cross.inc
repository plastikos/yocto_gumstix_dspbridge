DESCRIPTION = "Texas Instruments DSP BIOS."

SRC_URI = "\
           http://downloads.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/sysbios/${TI_PV}/exports/bios_setuplinux_${TI_PV}.bin \
           file://ti_license.txt \
          "

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"

DEPENDS = "ti-cgt6x-cross"

# TI renamed dspbios => sysbios
PROVIDES = "ti-dspbios"

inherit cross

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

S = "${WORKDIR}"

TI_TOOLS_DIR = "${TI_DEPOT_DIR}"
INSTALL_DIR = "${TI_TOOLS_DIR}"

PACAKGES = "${PN}"
FILES_${PN} = "${INSTALL_DIR}/*"


# Nothing to compile
do_compile() {
    :
}


do_install() {
    chmod 755 ./bios_setuplinux_${TI_PV}.bin
    env -u DISPLAY ./bios_setuplinux_${TI_PV}.bin --mode unattended --prefix "${D}${INSTALL_DIR}"
    #find "${D}${INSTALL_DIR}" -type d -print0 | xargs -0 chmod 755
    #chmod 755 \
    #    "${D}${INSTALL_DIR}"/*/xdctools/cdb2tcf \
    #    "${D}${INSTALL_DIR}"/*/xdctools/bioscfg \
    #    "${D}${INSTALL_DIR}"/*/xdctools/gmake \
    #    "${D}${INSTALL_DIR}"/*/xdctools/tconf \
    #    "${D}${INSTALL_DIR}"/*/xdctools/tconf.x86U \
    #    "${D}${INSTALL_DIR}"/*/xdctools/vers \
    #    "${D}${INSTALL_DIR}"/*/xdctools/xdc \
    #    "${D}${INSTALL_DIR}"/*/xdctools/xs \
    #    "${D}${INSTALL_DIR}"/*/xdctools/xs.x86U \
    #    "${D}${INSTALL_DIR}"/*/xdctools/bin/* \
}


do_populate_sysroot() {
    if [ "populate_sysroot" = "${BB_CURRENTTASK}" -o "populate_sysroot_setscene" = "${BB_CURRENTTASK}" ]; then
        # Ensure that ${INSTALL_DIR} gets put where it will be found
        mkdir -p "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}"
        tar -C "${D}" -cf - . | tar -C "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}" -xf -
    fi
}
