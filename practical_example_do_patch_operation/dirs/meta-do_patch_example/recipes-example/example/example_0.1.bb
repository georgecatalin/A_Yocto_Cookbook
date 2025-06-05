SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created to show the functioning of do_patch() build operation"
LICENSE = "MIT"

SRC_URI = "git://github.com/Munawar-git/bbb-tutorial-code.git;protocol=https;branch=master"
SRCREV = "f1be90c683cc1fe31f58f3f8b081562e8b5c8230"

SRC_URI:append = " file://0001-patch-example.patch"

S = "${WORKDIR}/git"

