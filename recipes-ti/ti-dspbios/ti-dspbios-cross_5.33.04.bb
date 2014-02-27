DESCRIPTION = "Texas Instruments DSP BIOS."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

PR = "r1"
TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"

DEPENDS = "ti-cgt6x-cross"

inherit cross

# TI_PKG_DIR should be set in layer.conf
FILESEXTRAPATHS_prepend := "${TI_PKG_DIR}:"

#http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dspbios/5_42_01_09/exports/bios_setuplinux_5_42_01_09.bin
SRC_URI = "\
           file://bios_setuplinux_${TI_PV}.bin \
           file://ti_license.txt \
          "

SRC_URI[md5sum] = "fcffe1618f20024fd6580f47cdc0059b"

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
    env -u DISPLAY ./bios_setuplinux_${TI_PV}.bin -Y --mode silent --prefix "${D}${INSTALL_DIR}"
    find "${D}${INSTALL_DIR}" -type d -print0 | xargs -0 chmod 755
    chmod 755 \
        "${D}${INSTALL_DIR}"/*/xdctools/cdb2tcf \
        "${D}${INSTALL_DIR}"/*/xdctools/bioscfg \
        "${D}${INSTALL_DIR}"/*/xdctools/gmake \
        "${D}${INSTALL_DIR}"/*/xdctools/tconf \
        "${D}${INSTALL_DIR}"/*/xdctools/tconf.x86U \
        "${D}${INSTALL_DIR}"/*/xdctools/vers \
        "${D}${INSTALL_DIR}"/*/xdctools/xdc \
        "${D}${INSTALL_DIR}"/*/xdctools/xs \
        "${D}${INSTALL_DIR}"/*/xdctools/xs.x86U \
        "${D}${INSTALL_DIR}"/*/xdctools/bin/* \
}


do_populate_sysroot() {
    if [ "populate_sysroot" = "${BB_CURRENTTASK}" -o "populate_sysroot_setscene" = "${BB_CURRENTTASK}" ]; then
        # Ensure that ${INSTALL_DIR} gets put where it will be found
        mkdir -p "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}"
        tar -C "${D}" -cf - . | tar -C "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}" -xf -
    fi
}
