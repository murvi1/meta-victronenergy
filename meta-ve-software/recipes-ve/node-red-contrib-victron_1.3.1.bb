SUMMARY = "Victron Venus D-Bus plugin for node-red"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d7725b8b5e691085738d564afb312302"

S = "${WORKDIR}/${PN}-${PV}"

RDEPENDS_${PN} += "\
	node-red \
"

SRC_URI = "\
     https://github.com/victronenergy/node-red-contrib-victron/archive/v${PV}.zip \
"

SRC_URI[md5sum] = "9217a75a7ec0ca6a371b8332042a5c03"
SRC_URI[sha256sum] = "c5f6d49fdcffce9ee916fe434beda9f529c0097a427f345604687cfefa78f54e"

NPM_ORG="victronenergy"

inherit npmve

NPM_INSTALLDIR = "${D}${libdir}/node_modules/@${NPM_ORG}/${PN}"

do_install_append() {
        # Remove hardware specific files
	rm -r ${NPM_INSTALLDIR}/node_modules/put/test
}
