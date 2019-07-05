SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

inherit kernel

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_CONFIG_COMMAND = "oe_runmake -C ${S} O=${B} ${KERNEL_CONFIG}"

LINUX_VERSION = "5.4"
LINUX_VERSION_VENUS = "1"
LINUX_VERSION_EXTENSION = "-venus-${LINUX_VERSION_VENUS}"

PV = "${LINUX_VERSION}${LINUX_VERSION_EXTENSION}"

SRC_URI = "https://github.com/victronenergy/linux/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "51dbfe46d7476af22b70fff5ad91a13f"
SRC_URI[sha256sum] = "c9e64ec9a4bbf213df501dfaeb6e488ed038251d48208ecde452ad6466d48940"

S = "${WORKDIR}/linux-${PV}"

do_configure_append() {
    sed -i 's/^\(CONFIG_LOCALVERSION=\).*/\1"${LINUX_VERSION_EXTENSION}"/' \
        .config
}

DEPENDS += "openssl-native"
HOST_EXTRACFLAGS += "-I${STAGING_INCDIR_NATIVE}"
