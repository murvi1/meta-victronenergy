SUMMARY = "Modbus for Node-RED"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4ce3d0350364f3efff545d6ba54f61eb"

RDEPENDS_${PN} += "\
	node-red \
"

SRC_URI = "\
	https://registry.npmjs.org/${PN}/-/${PN}-${PV}.tgz;unpack=0 \
	file://npm-shrinkwrap.json \
"

SRC_URI[md5sum] = "18b41eb8903591be86d46430d5cb52ed"
SRC_URI[sha256sum] = "778809bea7ca20c31907c9f4f490ee383ab8c22169c0251b8cb27dff244cb9da"

inherit npmve
