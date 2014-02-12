include ti-dspbridge-common_git.inc

inherit pkgconfig

DEPENDS = " \
    linux-gumstix \
    ti-dspbios-native \
    ti-cgt6x-native \
    "

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev ti-dspbridge-mpusamples ti-dspbridge-dsp"
FILES_ti-dspbridge-mpusamples = "/dspbridge/samples"
FILES_ti-dspbridge-dsp        = "/dspbridge/dsp"

do_compile() {

    cd "${S}/source"

    make \
        CROSS='${TARGET_PREFIX}' \
        KRNLSRC=${STAGING_KERNEL_DIR} \
        DEPOT=${STAGING_DIR_NATIVE}${TI_DEPOT_DIR} \
        .api

    make \
        CROSS='${TARGET_PREFIX}' \
        KRNLSRC=${STAGING_KERNEL_DIR} \
        DEPOT=${STAGING_DIR_NATIVE}${TI_DEPOT_DIR} \
        .samples

    make \
        CROSS='${TARGET_PREFIX}' \
        KRNLSRC=${STAGING_KERNEL_DIR} \
        DEPOT=${STAGING_DIR_NATIVE}${TI_DEPOT_DIR} \
        .dsp
}

do_install() {

    cd "${S}/source"
    
    #make \
    #    CROSS='${TARGET_PREFIX}' \
    #    KRNLSRC='${STAGING_KERNEL_DIR}' \
    #    DEPOT='${STAGING_DIR_NATIVE}${TI_DEPOT_DIR}' \
    #    TARGETDIR='${D}' \
    #    -f samplemakefile .install
    #
    #install -d "${D}/dspbridge/dsp"
    #mv "${D}/dspbridge/"*.dll64P "${D}/dspbridge/"*.dof64P "${D}/dspbridge/dsp/"

    oe_libinstall -so -C "${S}/source/target/lib" libbridge "${D}/${libdir}"
    oe_libinstall -so -C "${S}/source/target/lib" libqos "${D}/${libdir}"

    install -d "${D}${includedir}/dspbridge"
    install -m 0644 "${S}/source/mpu_api/inc/"*.h "${D}/${includedir}/dspbridge/"

    install -d "${D}/dspbridge/samples"
    install -m 0755 "${S}/source/target/dspbridge/"*.out "${D}/dspbridge/samples"
    install -m 0755 "${S}/source/samples/utils/install_bridge" "${D}/dspbridge/samples"
    install -m 0755 "${S}/source/samples/utils/install_bridge_128" "${D}/dspbridge/samples"
    install -m 0755 "${S}/source/samples/utils/uninstall_bridge" "${D}/dspbridge/samples"

    install -d ${D}/dspbridge/dsp
    install -m 0644 "${S}/source/samples/dsp/"*.dll64P "${S}/source/samples/dsp/"*.dof64P "${D}/dspbridge/dsp"

    printf "Installing STAGING_BINDIR: ${STAGING_BINDIR}/dspbridge/samples\n"
    install -d "${STAGING_BINDIR}/dspbridge/samples"
    install -m 0755 "${S}/source/target/dspbridge/"*.out "${STAGING_BINDIR}/dspbridge/samples"
}
