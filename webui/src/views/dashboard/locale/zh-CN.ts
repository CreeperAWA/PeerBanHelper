export default {
  'page.dashboard.description': '此页面展示 PeerBanHelper 自启动以来的基本数据。',
  'page.dashboard.clientStatus.title': '已连接的下载器',
  'page.dashboard.clientStatus.card.title': '下载器状态',
  'page.dashboard.clientStatus.card.status': '状态',
  'page.dashboard.clientStatus.card.type': '类型',
  'page.dashboard.clientStatus.card.status.normal': '正常',
  'page.dashboard.clientStatus.card.status.normal.info': '状态良好',
  'page.dashboard.clientStatus.card.status.error': '错误',
  'page.dashboard.clientStatus.card.status.error.info': '与客户端通信时出错，请检查日志文件',
  'page.dashboard.clientStatus.card.status.unknown': '未知',
  'page.dashboard.clientStatus.card.status.unknown.info': 'PeerBanHelper 可能还没有与此客户端通信',
  'page.dashboard.clientStatus.card.status.need_take_action': '需要采取行动',
  'page.dashboard.clientStatus.card.status.torrentNumber': '活动种子数',
  'page.dashboard.clientStatus.card.status.peerNumber': '已连接的Peers',
  'page.dashboard.clientStatus.card.lastDelete': '最后一个下载器不能被删除',
  'page.dashboard.statics.currentStatus': '当前状态',
  'page.dashboard.statics.checked': '共检查',
  'page.dashboard.statics.times': '次',
  'page.dashboard.statics.banPeer': '封禁Peer',
  'page.dashboard.statics.unbanPeer': '解除封禁',
  'page.dashboard.statics.currentBan': '当前处于封禁状态Peer',
  'page.dashboard.statics.currentBanIps': '正处于封禁的IP数量',
  'page.dashboard.statics.number': '个',
  'page.dashboard.torrentList.title': '活动种子',
  'page.dashboard.torrentList.column.name': '名称',
  'page.dashboard.torrentList.column.size': '大小',
  'page.dashboard.torrentList.column.hash': 'Hash',
  'page.dashboard.torrentList.column.progress': '进度',
  'page.dashboard.torrentList.column.speed': '速度',
  'page.dashboard.torrentList.column.view': '查看',
  'page.dashboard.editModal.title.new': '新建下载器',
  'page.dashboard.editModal.title.edit': '编辑下载器',
  'page.dashboard.editModal.label.type': '类型',
  'page.dashboard.editModal.label.name': '名称',
  'page.dashboard.editModal.label.endpoint': '地址',
  'page.dashboard.editModal.label.endpoint.error.invalidSchema': "必须以'http://'或'https://'开头",
  'page.dashboard.editModal.label.endpoint.error.invalidUrl': '无效的URL',
  'page.dashboard.editModal.label.username': '用户名',
  'page.dashboard.editModal.label.password': '密码',
  'page.dashboard.editModal.label.useBasicAuth': '使用 Basic Auth',
  'page.dashboard.editModal.label.httpVersion': 'HTTP版本',
  'page.dashboard.editModal.label.httpVersion.description': '2.0性能更好，1.1兼容性更好',
  'page.dashboard.editModal.label.incrementBan': '增量封禁',
  'page.dashboard.editModal.label.incrementBan.description':
    '有助于缓解保存封禁列表时的下载器压力，但在部分下载器上可能会导致无法封禁Peers',
  'page.dashboard.editModal.label.shadowBan': 'ShadowBan',
  'page.dashboard.editModal.label.shadowBan.description':
    '使用 qBittorrent Enhanced Edition 提供的 ShadowBan API 来代替传统 IP 屏蔽列表。<a href="https://pbh-btn.github.io/pbh-docs/docs/downloader/qBittorrentEE">了解更多</a>',
  'page.dashboard.editModal.label.verifySsl': '验证SSL证书',
  'page.dashboard.editModal.label.ignorePrivate': '忽略私有种子',
  'page.dashboard.editModal.label.ignorePrivate.description': '只在 qBittorrent 5.0+ 上有效',
  'page.dashboard.editModal.biglybt': '请先安装 {url}',
  'page.dashboard.editModal.biglybt.url': '插件',
  'page.dashboard.editModal.transmission.discourage':
    '警告：Transmission 适配器已被废弃，并将在将来的版本移除。https://github.com/PBH-BTN/PeerBanHelper/issues/382',
  'page.dashboard.peerList.title': '活动 Peer 列表：',
  'page.dashboard.peerList.column.address': '地址',
  'page.dashboard.peerList.column.port': '端口',
  'page.dashboard.peerList.column.clientName': '客户端名称',
  'page.dashboard.peerList.column.flag': '标志位',
  'page.dashboard.peerList.column.speed': '速度',
  'page.dashboard.peerList.column.uploadedDownloaded': '已上传/已下载',
  'page.dashboard.peerList.column.progress': '进度',
  'page.dashboard.peerList.column.flags.P': 'μtp',
  'page.dashboard.peerList.column.flags.d': '您：期待下载╱他：拒绝上传',
  'page.dashboard.peerList.column.flags.D': '您：期待下载╱他：同意上传',
  'page.dashboard.peerList.column.flags.u': '他：期待下载╱您：拒绝上传',
  'page.dashboard.peerList.column.flags.U': '他：期待下载╱您：同意上传',
  'page.dashboard.peerList.column.flags.K': '您：不想下载╱他：同意上传',
  'page.dashboard.peerList.column.flags.?': '他：不想下载╱您：同意上传',
  'page.dashboard.peerList.column.flags.O': '多传者优先',
  'page.dashboard.peerList.column.flags.S': '下载者突然停止',
  'page.dashboard.peerList.column.flags.I': '传入连接',
  'page.dashboard.peerList.column.flags.H': '来自 DHT 的下载者',
  'page.dashboard.peerList.column.flags.X': '来自 PEX 的下载者',
  'page.dashboard.peerList.column.flags.L': '来自 LSD 的下载者',
  'page.dashboard.peerList.column.flags.E': '加密的流量',
  'page.dashboard.peerList.column.flags.e': '加密握手'
}
