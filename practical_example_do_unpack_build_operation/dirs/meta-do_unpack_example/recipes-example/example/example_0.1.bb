SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"

SRC_URI = "git://github.com/Munawar-git/YoctoTutorials.git;protocol=https;branch=master"
SRCREV = "1a9af7d2b88cdc83cd9195e5a21e0be1ad61783c"


S = "${WORKDIR}/git"

python do_display_banner() {
    bb.plain("*************************************************************");
    bb.plain("*                                                           *");
    bb.plain("*  Example recipe to show how do_fetch() operation works    *");
    bb.plain("*                                                           *");
    bb.plain("*************************************************************");
}

addtask display_banner before do_build
