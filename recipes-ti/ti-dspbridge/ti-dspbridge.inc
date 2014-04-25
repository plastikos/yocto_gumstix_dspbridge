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

SABIOS_TI_VER = "${@bb.data.getVar('PREFERRED_VERSION_ti-dspbios-cross',d,1).replace('.', '_')}"
XDC_TI_VER = "${@bb.data.getVar('PREFERRED_VERSION_ti-xdctools-cross',d,1).replace('.', '_')}"

do_compile() {

    cd "${S}/source"

    DEPOT="${STAGING_DIR_NATIVE}${TI_DEPOT_DIR}"

    make \
        CROSS="${TARGET_PREFIX}" \
        KRNLSRC="${STAGING_KERNEL_DIR}" \
        DEPOT="${DEPOT}" \
	SABIOS_VER="${PREFERRED_VERSION_ti-dspbios-cross}" \
	SABIOS_VER_2="${SABIOS_TI_VER}" \
	CGT6X_VER="${PREFERRED_VERSION_ti-cgt6x-cross}" \
	DD_XDCDIR="${DEPOT}/xdctools_${XDC_TI_VER}" \
        .api

    make \
        CROSS="${TARGET_PREFIX}" \
        KRNLSRC="${STAGING_KERNEL_DIR}" \
        DEPOT="${DEPOT}" \
	SABIOS_VER="${PREFERRED_VERSION_ti-dspbios-cross}" \
	SABIOS_VER_2="${SABIOS_TI_VER}" \
	CGT6X_VER="${PREFERRED_VERSION_ti-cgt6x-cross}" \
	DD_XDCDIR="${DEPOT}/xdctools_${XDC_TI_VER}" \
        .samples

    make \
        CROSS="${TARGET_PREFIX}" \
        KRNLSRC="${STAGING_KERNEL_DIR}" \
        DEPOT="${DEPOT}" \
	SABIOS_VER="${PREFERRED_VERSION_ti-dspbios-cross}" \
	SABIOS_VER_2="${SABIOS_TI_VER}" \
	CGT6X_VER="${PREFERRED_VERSION_ti-cgt6x-cross}" \
	DD_XDCDIR="${DEPOT}/xdctools_${XDC_TI_VER}" \
        .dsp
}


do_install() {

    cd "${S}/source"
}
