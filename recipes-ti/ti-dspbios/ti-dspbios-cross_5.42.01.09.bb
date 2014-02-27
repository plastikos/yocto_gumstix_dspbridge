require ${PN}.inc

PR = "r1"

SRC_URI = "\
           http://downloads.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios/${TI_PV}/exports/bios_setuplinux_${TI_PV}.bin \
           file://ti_license.txt \
          "

SRC_URI[sha256sum] = "779181128a9b48522e435f6e43ee533bef7c21b89076338d468cd0b12aef64dc"
