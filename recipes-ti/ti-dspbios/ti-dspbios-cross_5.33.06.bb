require ${PN}.inc

PR = "r1"

# NOTICE: The bios_setuplinux_${TI_PV}.bin cannot be directly
# downloaded and requires a TI account.  Download it and put it in
# your TI_PKG_DIR as specified in the conf/local.conf.

SRC_URI = "\
           file://bios_setuplinux_${TI_PV}.bin \
           file://ti_license.txt \
          "

SRC_URI[sha256sum] = "52136fce50becd7ae711eebe8943f8a62d06d18f03f374aad8129a6e3dc7e887"
