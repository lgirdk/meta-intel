require linux-intel.inc

SRC_URI:prepend = "git://github.com/intel/linux-intel-lts.git;protocol=https;name=machine;branch=${KBRANCH}; \
                    "
SRC_URI:append = " file://0001-6.6-vt-conmakehash-improve-reproducibility.patch \
                   file://0001-6.6-lib-build_OID_registry-fix-reproducibility-issues.patch \
                  "
KBRANCH = "6.6/linux"
KMETA_BRANCH = "yocto-6.6"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "elfutils-native openssl-native util-linux-native"

LINUX_VERSION_EXTENSION ??= "-intel-pk-${LINUX_KERNEL_TYPE}"

LINUX_VERSION ?= "6.6.63"
SRCREV_machine ?= "248856fd22b40784d5b53ac2c600064502573b9d"
SRCREV_meta ?= "693358ea6816821663168ac9063d60e52a8ee4fe"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc \
                            features/security/security.scc \
                            features/intel-npu/intel-npu.scc"

UPSTREAM_CHECK_GITTAGREGEX = "^lts-(?P<pver>v6.6.(\d+)-linux-(\d+)T(\d+)Z)$"
