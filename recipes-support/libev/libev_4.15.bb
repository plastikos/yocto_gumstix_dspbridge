SUMMARY = "high-performance event loop library modelled after libevent"
DESCRIPTION = " \
libev provides a full-featured and high-performance event loop that is \
loosely modelled after libevent. It includes relative timers, absolute \
timers with customized rescheduling, synchronous signals, process status \
change events, event watchers dealing with the event loop itself, file \
watchers, and even limited support for fork events. It uses a priority \
queue to manage timers and uses arrays as fundamental data structure. It \
has no artificial limitations on the number of watchers waiting for the \
same event. \
 \
libev supports select, poll, epoll, kqueue, and inotify. \
"
HOMEPAGE = "http://libev.schmorp.de/"
SECTION = "libs"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a4460a29fc20be7a1a2e6c95660ec740"

PR = "r1"

SRC_URI = "http://dist.schmorp.de/libev/Attic/${BPN}-${PV}.tar.gz \
           file://1001_autotools.patch \
"
SRC_URI[md5sum] = "3a73f247e790e2590c01f3492136ed31"
SRC_URI[sha256sum] = "b2dd43a073556f5350cbed05b6ef444dcc4b563f4e0b1009d7bf448261606feb"

S = "${WORKDIR}/${BPN}-${PV}"

inherit autotools

# Needed for Debian packaging
LEAD_SONAME = "libev.so.4"


do_install_append () {
	# event.h conflicts with libevent - just delete it for now.  In the future
	# create a "compat" package for libevent-dev.
	rm -f "${D}${includedir}/event.h"
}
