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
    install -d "${D}${TI_DEPOT_DIR}/bdsptools"
    tar -C "${D}${TI_DEPOT_DIR}/bdsptools" -xf "${S}/source/dsp/bdsptools/bridge-tools.tar"
    rm -rf "${D}${TI_DEPOT_DIR}/bdsptools/"*.
}
