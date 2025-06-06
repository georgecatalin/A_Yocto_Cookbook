SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created to show the meaning of RPROVIDES"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"  

SRC_URI = " file://my_script.sh"
RDEPENDS:${PN}= "bash"

RPROVIDES:${PN} = "rprovides"

S = "${WORKDIR}"

do_install(){
    install -d ${D}${bindir}
    install -m 755 ${S}/my_script.sh ${D}${bindir}/
}
