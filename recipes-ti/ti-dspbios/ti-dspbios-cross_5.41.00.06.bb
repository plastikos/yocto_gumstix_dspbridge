require ${PN}.inc

PR = "r1"

SRC_URI = "\
           http://downloads.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/bios/dspbios/${TI_PV}/exports/bios_setuplinux_${TI_PV}.bin \
           file://ti_license.txt \
          "

SRC_URI[sha256sum] = "f35853b8ecbd8434ba96d1cc2b329451662d0059ab328ee11a5170c242d08518"
SRC_URI[md5sum] = "44851393e5858258ff0cd09b062e8f38"
