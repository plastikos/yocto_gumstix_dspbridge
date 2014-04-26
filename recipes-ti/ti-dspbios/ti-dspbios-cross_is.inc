DESCRIPTION = "Texas Instruments DSP BIOS."

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"

DEPENDS = "ti-cgt6x-cross"

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
    chmod 755 ./${TI_PKG}
    env -u DISPLAY ./${TI_PKG} -console <<EOF
1
q
1
0
1
${D}${INSTALL_DIR}
1

1
3
EOF
    rm -f "${D}{$INSTALL_DIR}/bios_install_log.txt"
}


do_populate_sysroot() {
    if [ "populate_sysroot" = "${BB_CURRENTTASK}" -o "populate_sysroot_setscene" = "${BB_CURRENTTASK}" ]; then
        # Ensure that ${INSTALL_DIR} gets put where it will be found
        mkdir -p "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}"
        tar -C "${D}" -cf - . | tar -C "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}" -xf -
    fi
}
