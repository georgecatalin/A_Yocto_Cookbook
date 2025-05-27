SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  Example recipe created by bitbake-layers   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

addtask display_banner before do_build


# understand assignment operators

TEST ?= "foo"
TEST ?= "bar"
TEST ?= "ngo"

# TEST will be "foo" as it is the first assignemnt with this operator

STEST ??= "car"
STEST ??= "ship"
STEST ??= "fighter"

# STEST = "fighter" as it is the last assignment as it happens with ??=

ZTEST ?= "foo"
ZTEST ??= "bar"
ZTEST ??= "dec"
ZTEST ?= "ngo"

# ZTEST = "foo" cause ?= has priority over ??= which is weaker


AX ?= "car"
AX = "ship" 

# = is expanded at the end(later) hence AX = "ship"

BX = "train"
CX = "${BX}"
BX = "tank"

# CX = "tank" because = expands later (in the end)

DX = "boat"
EX := "${DX}"
DX = "gun"

# EX = "boat" because := expands immediately


# += APPEND, =+ PREPEND

VAR1 = "foo"
VAR1  += "bar"
# VAR1 = "foo bar" as it is executed immediately and a space is added between

VAR2 ?= "george"
VAR2 += "calin"
# VAR2 = "george calin"

VAR3 = "foo"
VAR3 =+ "bar"
# VAR3 = "bar foo"


#####################
# understand .= append and =. prepend operators with no space between values

VAR4 = "mara"
VAR4 .= "calin"
# VAR4 = "maracalin" .= is applied immediately and it adds no space. space has to be added specifically

VAR5 = "sorina"
VAR5 =. "burssen"
# VAR5 = "burssensorina" =. is applied immediately and it adds no space. space has to be added specifically


###########################################
# understand :append, :prepend, :remove


VAR6 = "george"
VAR6:append = "calin"
# VAR6 = "georgecalin" , :append is not applied immediately and it does not introduce any space

VAR7 = "mara"
VAR7:append = "calin"
VAR7 += "bibbex"
# VAR7 = "mara bibbexcalin" as += is applied immediately and comes with a space, and :append is applied later(in the end) without a space


VAR8 = "sorina"
VAR8:prepend = "calin"
VAR8 =+ "burssen"
#VAR8 = "calinburssen sorina" as =+ prepend is applied immediately with a space in between , and :prepend later

VAR9 = "foo bar bar foo bar foo"
VAR9:remove = "foo"
#VAR9 = " bar bar bar "
