PR = "r1"

XTRACT_ARGS = "--mode silent"

require ti-xdctools.inc

SRC_URI = "\
           file://${TI_PKG} \
           file://ti_license.txt \
          "

SRC_URI[md5sum] = "4a460d7974f271c2e686ada8ddf2a117"
