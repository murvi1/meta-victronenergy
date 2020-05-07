SUMMARY = "Extra packages for large image"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup
LICENSE = "MIT"

RDEPENDS_${PN} = "\
    node-red \
    node-red-dashboard \
    nodejs-npm \
    packagegroup-core-buildessential \
    signalk-server \
    node-red-contrib-victron \
"
