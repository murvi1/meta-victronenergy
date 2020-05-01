SUMMARY = "A dashboard UI for Node-RED"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f289d543031cf6f8f1943a54d087eeac"

RDEPENDS_${PN} += "\
	node-red \
"

SRC_URI = "\
	https://registry.npmjs.org/${PN}/-/${PN}-${PV}.tgz;unpack=0 \
	file://npm-shrinkwrap.json \
"

SRC_URI[md5sum] = "5e273d8be5d8ee3e21aab562c5abdaa9"
SRC_URI[sha256sum] = "54c27a2a26b42378658290228c54a0e94606e2bb2e97dd44b0fa312e02773255"

# prevent npm.bbclass from stripping off the node- from our package name. Doing so leads to
# errors when building with a openembedded-core version that includes this commit:
# https://github.com/openembedded/openembedded-core/commit/6b417c7c3a38463c64756beae9817fa2a80fd09e
NPMPN = "node-red-dashboard"

inherit npm

# npm.bbclass assumes we've been using the npm fetcher. Ofcourse we didn't; its eternally slow.
S = "${WORKDIR}/${PN}-${PV}"

# Skip the arch QA check, since it trips over some precompiled binaries in the put npm module:
# https://github.com/substack/node-put/issues/5
# Removing those files in do_compile_append() doesn't work with the recent npm.bbclass; as it
# runs npm install again in do_install() - which is weird; but thats how it is.

INSANE_SKIP_${PN} += "arch"


