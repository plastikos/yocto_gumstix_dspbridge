PR = "r1"

# NOTICE: The bios_setuplinux_${TI_PV}.bin cannot be directly
# downloaded and requires a TI account.  Download it and put it in
# your TI_PKG_DIR as specified in the conf/local.conf.

TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"
TI_PKG = "bios_setuplinux_${TI_PV}.bin"

SRC_URI = "\
           file://${TI_PKG} \
           file://ti_license.txt \
          "

SRC_URI[sha256sum] = "52136fce50becd7ae711eebe8943f8a62d06d18f03f374aad8129a6e3dc7e887"

require ${PN}.inc
