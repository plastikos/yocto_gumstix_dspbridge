require linux.inc

PROVIDES += "linux-gumstix"
PROVIDES += "virtual/kernel"

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "overo"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"
PV = "3.8"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;branch=v3.8;protocol=git \
           file://defconfig \
           file://${BOOT_SPLASH} \
           "
