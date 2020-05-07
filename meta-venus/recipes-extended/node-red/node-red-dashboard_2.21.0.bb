SUMMARY = "A dashboard UI for Node-RED"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f289d543031cf6f8f1943a54d087eeac"

S = "${WORKDIR}/${PN}-${PV}"

RDEPENDS_${PN} += "\
	node-red \
"
SRC_URI = "\
	https://registry.npmjs.org/${PN}/-/${PN}-${PV}.tgz;unpack=0 \
	file://npm-shrinkwrap.json \
"

SRC_URI[md5sum] = "17458e14e19d9a038561ff1b07283a14"
SRC_URI[sha256sum] = "2bb255d753db10c50fc64c27b2dd19e58e58003576dbd1cb11571b4c2916ba61"

inherit npmve
