inherit cross


do_install_append() {
    # FIXME: The kernel build should install the dspbride files into
    # /usr/include/linux

    # Install TI Bridgetools which are only found in ti-dspbridge source
    rm -rf "${D}${TI_DEPOT_DIR}/dspbridge"
    install -d "${D}${TI_DEPOT_DIR}/dspbridge"
    cp -a "${S}/source/dsp" "${D}${TI_DEPOT_DIR}/dspbridge/dsp"

    # framework_components has its own recipe - do not use the bundled version
    rm -rf "${D}${TI_DEPOT_DIR}/dspbridge/dsp/bdsptools/framework_components_"*
    # Don't need the silly .tar files
    rm -f "${D}${TI_DEPOT_DIR}/dspbridge/dsp/bdsptools/"*.tar

    cp -a "${S}/source/mpu_api" "${D}${TI_DEPOT_DIR}/dspbridge/mpu"
    rm -rf "${D}${TI_DEPOT_DIR}/dspbridge/mpu/src"
    install -d "${D}${TI_DEPOT_DIR}/dspbridge/mpu/lib"

    oe_libinstall -so -C "${S}/source/target/lib" libbridge "${D}${TI_DEPOT_DIR}/dspbridge/mpu/lib"
    oe_libinstall -so -C "${S}/source/target/lib" libqos    "${D}${TI_DEPOT_DIR}/dspbridge/mpu/lib"

    install -d "${D}${TI_DEPOT_DIR}/dspbridge/mpu/inc"
    # NOTE: the source/samples/mpu/inc is more complete than source/mpu_api_inc
    # It is unclear why they are comparable, yet different.
    # install -m 0644 "${S}/source/mpu_api/inc/"*.h "${D}${TI_DEPOT_DIR}/dspbridge/mpu/inc"
    install -m 0644 "${S}/source/samples/mpu/inc/"*.h "${D}${TI_DEPOT_DIR}/dspbridge/mpu/inc"
}


do_populate_sysroot() {
    if [ "populate_sysroot" = "${BB_CURRENTTASK}" -o "populate_sysroot_setscene" = "${BB_CURRENTTASK}" ]; then
        # Ensure that ${INSTALL_DIR} gets put where it will be found
        mkdir -p "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}"
        tar -C "${D}" -cf - . | tar -C "${SYSROOT_DESTDIR}${STAGING_DIR_NATIVE}" -xf -
    fi
}
