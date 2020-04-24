SUMMARY = "Victron Venus D-Bus plugin for node-red"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d7725b8b5e691085738d564afb312302"

RDEPENDS_${PN} += "\
	node-red \
"

SRC_URI = "\
     https://github.com/victronenergy/${PN}/archive/${PV}.zip \
"

SRC_URI[md5sum] = "8f5ba4721505d6028f073c918f93aa13"
SRC_URI[sha256sum] = "2344469c0b950745f8cb5e4dd27cb67fac7f044a437f2ed15436cd14d9377343"

# prevent npm.bbclass from stripping off the node- from our package name. Doing so leads to
# errors when building with a openembedded-core version that includes this commit:
# https://github.com/openembedded/openembedded-core/commit/6b417c7c3a38463c64756beae9817fa2a80fd09e
NPMPN = "node-red-contrib-victron"

inherit npm

# npm.bbclass assumes we've been using the npm fetcher. Ofcourse we didn't; its eternally slow.
S = "${WORKDIR}/${PN}-${PV}"

# Skip the arch QA check, since it trips over some precompiled binaries in the put npm module:
# https://github.com/substack/node-put/issues/5
# Removing those files in do_compile_append() doesn't work with the recent npm.bbclass; as it
# runs npm install again in do_install() - which is weird; but thats how it is.

INSANE_SKIP_${PN}-put += "arch"
