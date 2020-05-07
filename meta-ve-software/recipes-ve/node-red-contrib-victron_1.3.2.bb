SUMMARY = "Victron Venus D-Bus plugin for node-red"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d7725b8b5e691085738d564afb312302"

S = "${WORKDIR}/${PN}-${PV}"

RDEPENDS_${PN} += "\
	node-red \
"

SRC_URI = "\
	https://registry.npmjs.org/@${NPM_ORG}/${PN}/-/${PN}-${PV}.tgz;unpack=0 \
	file://npm-shrinkwrap.json \
"

SRC_URI[md5sum] = "d794d28fede1b3d26047f06e73a5b6e5"
SRC_URI[sha256sum] = "a71109d4e8ba7d068fe81b60add56f1f65e64f99e0f44ee1d02df892d314eaaa"

NPM_ORG="victronenergy"

inherit npmve

NPM_INSTALLDIR = "${D}${libdir}/node_modules/@${NPM_ORG}/${PN}"

do_install_append() {
        # Remove hardware specific files
	rm -r ${NPM_INSTALLDIR}/node_modules/put/test
}
