PRIORITY = "optional"
DESCRIPTION = "Texas Instruments MPU/DSP Bridge libraries, utilities."
LICENSE = "GPLv2"

S = "${WORKDIR}/git"

DEPENDS = " \
    linux-gumstix \
    ti-cgt6x-cross \
    ti-dspbios-cross \
    "

inherit autotools


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
}
