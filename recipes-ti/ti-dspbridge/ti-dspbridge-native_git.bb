include ti-dspbridge-common_git.inc

inherit native

DEPENDS = " \
    linux-gumstix \
    ti-dspbios-native \
    ti-cgt6x-native \
    "

PACKAGES = "ti-bridgetools"
FILES_ti-bridgetools   = "${TI_DEPOT_DIR}/bdsptools"

do_compile() {
    :
}

do_install() {

    cd "${S}/source"

    # Install TI Bridgetools which are only found in ti-dspbridge source
    rm -rf "${D}${TI_DEPOT_DIR}/bdsptools"
    install -d "${D}${TI_DEPOT_DIR}/bdsptools"
    tar -C "${D}${TI_DEPOT_DIR}/bdsptools" -xf "${S}/source/dsp/bdsptools/bridge-tools.tar"
}


do_populate_sysroot() {
    if [ "populate_sysroot" = "${BB_CURRENTTASK}" -o "populate_sysroot_setscene" = "${BB_CURRENTTASK}" ]; then
        # Ensure that ${INSTALL_DIR} gets put where it will be found
        mkdir -p "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}"
        tar -C "${D}" -cf - ./"${TI_DEPOT_DIR}/bdsptools" | tar -C "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}" -xf -
    fi
}
