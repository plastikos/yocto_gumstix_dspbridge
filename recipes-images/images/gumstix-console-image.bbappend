# EXTRA_IMAGE_INSTALL packages can be set in conf/layer.conf

#IMAGE_INSTALL += "${EXTRA_IMAGE_INSTALL}"
IMAGE_INSTALL_append = " ${EXTRA_IMAGE_INSTALL}"

# FIXME: media-ctl requires linux/media.h which does not exist in the kernel
# being used.
#IMAGE_INSTALL_remove = "media-ctl"
TOOLS_INSTALL_remove = "media-ctl"
TOOLS_INSTALL_remove = "systemd-analyze"
