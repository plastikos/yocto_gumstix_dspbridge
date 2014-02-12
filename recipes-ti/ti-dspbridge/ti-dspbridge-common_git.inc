PRIORITY = "optional"
DESCRIPTION = "Texas Instruments MPU/DSP Bridge libraries, utilities."
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "\
    file://source/mpu_api/COPYING;md5=7266a93b753b03bc5f00522e65722b79\
    file://source/samples/LICENSE;md5=d229da563da18fe5d58cd95a6467d584\
    "

PR = "r1"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
PV = "23.0+git+${SRCREV}"

SRC_URI = "git://dev.omapzoom.org/pub/scm/tidspbridge/userspace-dspbridge.git;protocol=git;branch=master \
           file://build_mk_fix.patch \
          "
