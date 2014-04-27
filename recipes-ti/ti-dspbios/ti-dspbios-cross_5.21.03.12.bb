PR = "r2"

TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"
TI_PKG = "dsp_bios_setuplinux_${TI_PV}.sh"

# NOTICE: The bios_setuplinux_${TI_PV}.bin cannot be directly
# downloaded and requires a TI account.  Download it and put it in
# your TI_PKG_DIR as specified in the conf/local.conf.

SRC_URI = "http://software-dl.ti.com/targetcontent/legacy_files/targetcontent/bios/bios_5_21/sabios-f12/${TI_PKG}"

SRC_URI[md5sum] = "a6706eb908febad37f26c7cd4975df90"
SRC_URI[sha256sum] = "29cdbb74c1bd287808aad6a460cc23290a8f42c446ba7d00c38ff50a841011ce"

require ${PN}_is.inc


do_install_append() {
    # Just doesn't install in a correctly versioned directory - fix it.
    mv "${D}${INSTALL_DIR}/bios_5"* "${D}${INSTALL_DIR}/bios_${TI_PV}"
}
