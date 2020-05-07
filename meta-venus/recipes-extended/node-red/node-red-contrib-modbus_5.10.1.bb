SUMMARY = "Modbus for Node-RED"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ce3d0350364f3efff545d6ba54f61eb"

S = "${WORKDIR}/${PN}-${PV}"

RDEPENDS_${PN} += "\
	node-red \
"

SRC_URI = "\
	https://registry.npmjs.org/${PN}/-/${PN}-${PV}.tgz;unpack=0 \
	file://npm-shrinkwrap.json \
"

SRC_URI[md5sum] = "948170979311cf634aee299dc9bb7150"
SRC_URI[sha256sum] = "6271775a81fec5e0cb9e9f6341e875f18d28dd2ae8a7f64e4e25819b0917e27c"

inherit npmve
