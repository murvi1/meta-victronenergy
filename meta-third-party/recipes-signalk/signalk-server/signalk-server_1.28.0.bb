DESCRIPTION = "Node-RED"
HOMEPAGE = "http://nodered.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34f8c1142fd6208a8be89399cb521df9"

RDEPENDS_${PN} += "\
	bash \
"

SRC_URI = "\
	https://registry.npmjs.org/signalk-server/-/${PN}-${PV}.tgz \
	file://start-signalk.sh \
	file://settings.json \
	file://venus.json \
	file://defaults.json \
"

SRC_URI[md5sum] = "91f496c501e62e52133a87cb0f18a67e"
SRC_URI[sha256sum] = "fc933e23486a1f674505d335f987a7605cb235a03493a247549870ee09213f39"

NPM_COMPILE_COMMAND = "build"

inherit npmve
inherit daemontools

DAEMON_PN = "${PN}"
DAEMONTOOLS_SERVICE_DIR = "${sysconfdir}/${PN}/service"
DAEMONTOOLS_SCRIPT = "HOME=/home/root exec ${bindir}/signalk-server"
DAEMONTOOLS_DOWN = "1"
DAEMONTOOLS_LOG_DIR = "${DAEMONTOOLS_LOG_DIR_PREFIX}/signalk-server"

NPM_INSTALLDIR = "${D}${libdir}/node_modules/${PN}"

do_compile_prepend() {
	echo "sk do_compile_prepend"
	mv ${WORKDIR}/package/* ${WORKDIR}/${PN}-${PV}
}

do_install_append() {
	INSTALLDIR=${D}${libdir}/node_modules/signalk-server

	mkdir ${D}${bindir}
	install -m 0755 ${WORKDIR}/start-signalk.sh ${D}${bindir}/signalk-server

	# this folder keeps the default settings. start-signalk.sh copies them
	# to the data partition on first boot.
	install -d ${INSTALLDIR}/defaults
	install -m 0755 ${WORKDIR}/settings.json ${INSTALLDIR}/defaults
	install -m 0755 ${WORKDIR}/defaults.json ${INSTALLDIR}/defaults
	install -m 0755 ${WORKDIR}/venus.json ${INSTALLDIR}/defaults

	(cd ${INSTALLDIR}; npm --arch=${NPM_ARCH} --target_arch=${NPM_ARCH} install signalk-venus-plugin@1.15.0)

	# remove the files in put/test: they are compiled, though not cross-compiled thus
	# giving QA errors as well as being useless; and also they are not necessary
	rm -rf ${INSTALLDIR}/node_modules/put/test
}

