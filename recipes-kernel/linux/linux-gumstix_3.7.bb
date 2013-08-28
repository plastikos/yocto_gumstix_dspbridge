require linux.inc

PROVIDES += "virtual/kernel"

DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "overo"

BOOT_SPLASH ?= "logo_linux_clut224-generic.ppm"
PV = "3.7"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;branch=v3.7;protocol=git \
           file://omap_hsmmc-3.5.patch \
           file://omap_dma_mask.patch \
           file://spi-omap2-mcspi-3.5.patch \
           file://arm_plat-3.5.patch \
           file://dspbridge_debug.patch \
           file://defconfig \
           file://${BOOT_SPLASH} \
           "
