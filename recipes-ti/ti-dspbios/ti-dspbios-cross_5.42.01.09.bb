PR = "r1"

TI_PV = "${@bb.data.getVar('PV',d,1).replace('.', '_')}"
TI_PKG = "bios_setuplinux_${TI_PV}.bin"

SRC_URI = "\
           http://downloads.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios/${TI_PV}/exports/${TI_PKG} \
           file://ti_license.txt \
          "

SRC_URI[sha256sum] = "779181128a9b48522e435f6e43ee533bef7c21b89076338d468cd0b12aef64dc"

require ${PN}.inc
