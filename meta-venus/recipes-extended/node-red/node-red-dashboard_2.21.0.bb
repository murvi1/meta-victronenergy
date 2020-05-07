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

SRC_URI[md5sum] = "5e273d8be5d8ee3e21aab562c5abdaa9"
SRC_URI[sha256sum] = "54c27a2a26b42378658290228c54a0e94606e2bb2e97dd44b0fa312e02773255"

inherit npmve
