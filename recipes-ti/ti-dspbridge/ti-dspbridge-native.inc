PACKAGES += "libdspbridge libdspbridge-dev libdspbridge-dbg libdspbridge-staticdev ti-dspbridge-mpusamples ti-dspbridge-dsp"
FILES_libdspbridge     = "${libdir}/*.so.*"
FILES_${PN}-mpusamples = "/dspbridge/samples"
FILES_${PN}-dsp        = "/dspbridge/dsp"

INHIBIT_PACKAGE_STRIP = "1"


do_install_append() {
    # FIXME: The kernel build should install the dspbride files into
    # /usr/include/linux

    oe_libinstall -so -C "${S}/source/target/lib" libbridge "${D}${libdir}"
    oe_libinstall -so -C "${S}/source/target/lib" libqos    "${D}${libdir}"

    install -d "${D}${includedir}/dspbridge"
    # NOTE: the source/samples/mpu/inc is more complete than source/mpu_api_inc
    # It is unclear why they are comparable, yet different.
    # install -m 0644 "${S}/source/mpu_api/inc/"*.h "${D}${includedir}/dspbridge/"
    install -m 0644 "${S}/source/samples/mpu/inc/"*.h "${D}${includedir}/dspbridge/"

    install -d "${D}/dspbridge/samples"
    install -m 0755 "${S}/source/target/dspbridge/"*.out "${D}/dspbridge/samples"

    install -d ${D}/dspbridge/dsp
    install -m 0644 "${S}/source/samples/dsp/"*.dll64P "${S}/source/samples/dsp/"*.dof64P "${D}/dspbridge/dsp"
}
