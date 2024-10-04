#!/bin/bash
# Copyright (c) 2000-2020 Synology Inc. All rights reserved.

source /pkgscripts/include/pkg_util.sh

package="peerbanhelper"
version="@PBH_VERSION@"
displayname="PeerBanHelper"
os_min_ver="7.2-64555"
maintainer="PBH-BTN"
maintainer_url="https://github.com/PBH-BTN/PeerBanHelper"
thirdparty="yes"
#beta="no"
dsmappname="SYNO.SDS.peerbanhelper.Application"
install_dep_packages="ContainerManager>=20.10.23-1432:ContainerManager<24.0.2-1520"
#arch="$(pkg_get_platform)"
arch="noarch"
description="自动封禁不受欢迎、吸血和异常的 BT 客户端，并支持自定义规则。PeerId黑名单/UserAgent黑名单/IP CIDR/假进度/超量下载/进度回退/多播追猎/连锁封禁/伪装检测 支持 qBittorrent/Transmission/Deluge/BiglyBT/Vuze(Azureus)/BitComet"
dsmuidir="ui"
[ "$(caller)" != "0 NULL" ] && return 0
pkg_dump_info
