DESCRIPTION = "Node-RED"
HOMEPAGE = "http://nodered.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d6f37569f5013072e9490d2194d10ae6"

S = "${WORKDIR}/${PN}"

SRC_URI = "\
	https://github.com/${PN}/${PN}/releases/download/${PV}/${PN}-${PV}.zip \
	file://npm-shrinkwrap.json \
"

SRC_URI[md5sum] = "f00fd7a358f3798c51acb5b7d1a2a616"
SRC_URI[sha256sum] = "6eb515a0e97af67c152029d4f9234a2a87518822410dc6febf76fa6575877773"

inherit npmve
inherit daemontools
	
DAEMON_PN = "${PN}"
DAEMONTOOLS_SERVICE_DIR = "/etc/node-red/service"
DAEMONTOOLS_SCRIPT = "HOME=/home/root exec ${bindir}/node-red"
DAEMONTOOLS_DOWN = "1"
DAEMONTOOLS_LOG_DIR = "${DAEMONTOOLS_LOG_DIR_PREFIX}/node-red"

NPM_INSTALLDIR = "${D}${libdir}/node_modules/${PN}"

do_install_append() {
        # Remove hardware specific files
	rm ${NPM_INSTALLDIR}/bin/node-red-pi	

	# Symlinks
	mkdir ${D}${bindir}
	ln -s ${libdir}/node_modules/${PN}/red.js ${D}${bindir}/${PN}
}

FILES_${PN} += " \
    ${bindir}/node-red \
"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"