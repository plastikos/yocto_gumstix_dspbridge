SUMMARY = "Evented Networking in C (using libev)"
DESCRIPTION = " \
libevnet is essentially the net module of Node.JS (v0.2.6), implemented in C \
"
HOMEPAGE = "https://github.com/coolaj86/libevn"
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.MIT;md5=e62183c2036b4d60ee6e7842f6f7c04c"

PR = "r0"

SRC_URI = "git://github.com/coolaj86/libevn.git;protocol=git;branch=master"
SRCREV = "c10267890a995b3930ddaa743639258d3fba401a"

S = "${WORKDIR}/git"

inherit cmake

OECMAKE_SOURCEPATH = "${S}/source"

# Needed for Debian packaging
LEAD_SONAME = "libevn.so.4"
