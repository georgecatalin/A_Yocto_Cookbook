SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created to show the functioning of do_patch() build operation"
LICENSE = "MIT"

SRC_URI = "git://github.com/Munawar-git/bbb-tutorial-code.git;protocol=https;branch=master"
SRCREV = "f1be90c683cc1fe31f58f3f8b081562e8b5c8230"

SRC_URI:append = " file://0001-patch-example.patch"

S = "${WORKDIR}/git"

do_configure(){

    echo " // this code is added via do_configure() operation in the bitbake build execution \n" > bbb-example.h
    echo "#define WELCOME y" >> bbb-example.h
    echo "#define HELLO y" >> bbb-example.h
}

do_compile(){
    ${CC} ${CFLAGS} ${LDFLAGS} ${S}/bbb-example.c -o bbb-example
}

do_install(){
    install -d ${D}${bindir}
    install -m 755 ${S}/bbb-example ${D}${bindir}
}