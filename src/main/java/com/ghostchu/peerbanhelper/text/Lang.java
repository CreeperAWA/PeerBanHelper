package com.ghostchu.peerbanhelper.text;

public class Lang {
    public static final String ERR_BUILD_NO_INFO_FILE = "错误：构建信息文件不存在";
    public static final String ERR_CANNOT_LOAD_BUILD_INFO = "错误：无法加载构建信息文件";
    public static final String MOTD = "PeerBanHelper v{} - by Ghost_chu";
    public static final String LOADING_CONFIG = "正在加载配置文件……";
    public static final String CONFIG_PEERBANHELPER = "已初始化目录结构，相关文件已放置在运行目录的 data 文件夹下，请配置相关文件后，再重新启动 PeerBanHelper";
    public static final String ERR_SETUP_CONFIGURATION = "错误：无法初始化配置文件结构";
    public static final String DISCOVER_NEW_CLIENT = " + {} -> {} ({})";
    public static final String ERR_INITIALIZE_BAN_PROVIDER_ENDPOINT_FAILURE = "错误：无法初始化 API 提供端点，Transmission 模块的封禁功能将不起作用";
    public static final String WAIT_FOR_MODULES_STARTUP = "请等待功能模块初始化……";
    public static final String MODULE_REGISTER = "[注册] {}";
    public static final String MODULE_UNREGISTER = "[解注册] {}";
    public static final String ERR_CLIENT_LOGIN_FAILURE_SKIP = "登录到 {} ({}) 失败，跳过……";
    public static final String ERR_UNEXPECTED_API_ERROR = "在处理 {} ({}) 的 API 操作时出现了一个非预期的错误";
    public static final String PEER_UNBAN_WAVE = "[解封] 解除了 {} 个过期的对等体封禁";
    public static final String ERR_UPDATE_BAN_LIST = "在更新 {} ({}) 的封禁列表时出现了一个非预期的错误";
    public static final String BAN_PEER = "[封禁] {}, PeerId={}, ClientName={}, Progress={}, Uploaded={}, Downloaded={}, Torrent={}, Reason={}";
    public static final String CHECK_COMPLETED = "[完成] 已检查 {} 的 {} 个活跃 Torrent 和 {} 个对等体";
    public static final String ERR_INVALID_RULE_SYNTAX = "规则 {} 的表达式无效，请检查是否存在拼写错误";
    public static final String MODULE_CNB_MATCH_CLIENT_NAME = "匹配 ClientName (UserAgent): %s";
    public static final String MODULE_IBL_MATCH_IP = "匹配 IP 规则: %s";
    public static final String MODULE_IBL_MATCH_IP_RULE = "匹配 IP黑名单订阅 规则: %s";
    public static final String MODULE_IBL_MATCH_ASN = "匹配 ASN 规则: %s";
    public static final String MODULE_IBL_MATCH_REGION = "匹配国家或地区 ISO 代码规则: %s";
    public static final String MODULE_IBL_EXCEPTION_GEOIP = "匹配 GeoIP 信息时出现异常，请反馈错误给开发者";
    public static final String MODULE_IBL_MATCH_PORT = "匹配 Port 规则: %s";
    public static final String MODULE_PID_MATCH_PEER_ID = "匹配 PeerId 规则: %s";
    public static final String MODULE_PCB_EXCESSIVE_DOWNLOAD = "客户端下载过量：种子大小：%d，上传给此对等体的总量：%d，最大允许的过量下载总量：%d";
    public static final String MODULE_PCB_PEER_MORE_THAN_LOCAL_SKIP = "客户端进度：%s，实际进度：%s，客户端的进度多于本地进度，跳过检测";
    public static final String MODULE_PCB_PEER_BAN_INCORRECT_PROGRESS = "客户端进度：%s，实际进度：%s，差值：%s";
    public static final String MODULE_PCB_PEER_BAN_REWIND = "客户端进度：%s，实际进度：%s，上次记录进度：%s，本次进度：%s，差值：%s";
    public static final String MODULE_PCB_SKIP_UNKNOWN_SIZE_TORRENT = "种子大小未知";
    public static final String GUI_BUTTON_RESIZE_TABLE = "点击调整列宽";
    public static final String MODULE_AP_SSL_CONTEXT_FAILURE = "初始化 SSLContext 时出错";
    public static final String MODULE_MDB_MULTI_DIALING_NOT_DETECTED = "未发现多拨下载，种子名称：{}";
    public static final String MODULE_MDB_MULTI_DIALING_DETECTED = "发现多拨下载，请持续关注，种子名称：{}，子网：{}，触发IP：{}";
    public static final String MODULE_MDB_MULTI_DIALING_HUNTING_TRIGGERED = "触发多拨追猎名单，种子名称：{}，子网：{}，触发IP：{}";
    public static final String DOWNLOADER_QB_LOGIN_FAILED = "登录到 {} 失败：{} - {}: \n{}";
    public static final String DOWNLOADER_QB_FAILED_REQUEST_TORRENT_LIST = "请求 Torrents 列表失败 - %d - %s";
    public static final String DOWNLOADER_QB_FAILED_REQUEST_PEERS_LIST_IN_TORRENT = "请求 Torrent 的 Peers 列表失败 - %d - %s";
    public static final String DOWNLOADER_QB_API_PREFERENCES_ERR = "qBittorrent 的首选项 API 返回了非 200 预期响应 - %d - %s";
    public static final String DOWNLOADER_QB_FAILED_SAVE_BANLIST = "无法保存 {} ({}) 的 Banlist！{} - {}\n{}";
    public static final String DOWNLOADER_TR_MOTD_WARNING = "[受限] 由于 Transmission 的 RPC-API 限制，PeerId 黑名单功能和 ProgressCheatBlocker 功能的过量下载模块不可用";
    public static final String DOWNLOADER_TR_DISCONNECT_PEERS = "[重置] 正在断开 Transmission 上的 {} 个种子连接的对等体，以便应用 IP 屏蔽列表的更改";
    public static final String DOWNLOADER_TR_INCORRECT_BANLIST_API_RESP = "设置 Transmission 的 BanList 地址时，返回非成功响应：{}。";
    public static final String DOWNLOADER_TR_INCORRECT_SET_BANLIST_API_RESP = """
            无法应用 IP 黑名单到 Transmission，PBH 没有生效！
            请求 Transmission 更新 BanList 时，返回非成功响应。
            您是否正确映射了 PeerBanHelper 的外部交互端口，以便 Transmission 从 PBH 拉取 IP 黑名单？
            检查 Transmission 的 设置 -> 隐私 -> 屏蔽列表 中自动填写的 URL 是否正确，如果不正确，请在 PeerBanHelper 的 config.yml 中正确配置 server 部分的配置文件，确保 Transmission 能够正确连接到 IP 黑名单提供端点
            """;
    public static final String DOWNLOADER_TR_INVALID_RESPONSE = "[错误] Transmission 返回无效 JSON 响应: {}";
    public static final String DOWNLOADER_TR_UPDATED_BLOCKLIST = "[响应] Transmission 屏蔽列表已更新成功，现在包含 {} 条规则";
    public static final String DOWNLOADER_TR_KNOWN_INCOMPATIBILITY = "[错误] 您正在使用的 Transmission 版本与 PeerBanHelper 不兼容: %s";
    public static final String DOWNLOADER_TR_INCOMPATIBILITY_BANAPI = "当前版本存在封禁 API 的已知问题，请升级至 3.0-20 或更高版本";
    public static final String ERR_CONFIG_DIRECTORY_INCORRECT = "初始化失败：config 不是一个目录。如果您正在使用 Docker，请确保其正确挂载。";
    public static String WEB_ENDPOINT_REGISTERED = "[注册] WebAPI 端点已注册：{}";
    public static String SKIP_LOAD_PLUGIN_FOR_NATIVE_IMAGE = "检测到Native Images，跳过加载插件";
    public static final String PBH_SHUTTING_DOWN = "[退出] 正在退出，请等待我们完成剩余的工作……";
    public static String ERR_CANNOT_LOAD_PLUGIN = "[注册] 无法加载插件：{}";
    public static String ERR_CANNOT_UNLOAD_PLUGIN = "[退出] 无法卸载插件：{}";
    public static String ARB_ERROR_TO_CONVERTING_IP = "IP 地址 %s 既不是 IPV4 地址也不是 IPV6 地址。";
    public static final String ARB_BANNED = "IP 地址 %s 与另一个已封禁的 IP 地址 %s 处于同一封禁区间 %s 内，执行连锁封禁操作。";
    public static final String DATABASE_SETUP_FAILED = "[错误] 数据库初始化失败";
    public static String DATABASE_BUFFER_SAVED = "[保存] 已保存 {} 条内存缓存的封禁日志到数据库，用时 {}ms";
    public static final String DATABASE_SAVE_BUFFER_FAILED = "[错误] 刷写内存缓存的封禁日志时出现了 SQL 错误，未保存的数据已被丢弃";
    public static final String WEB_BANLOGS_INTERNAL_ERROR = "[错误] 读取封禁日志时遇到非预期错误";
    public static String PERSIST_DISABLED = "[禁用] Persist 持久化数据存储已在此服务器上被禁用";
    public static final String BOOTSTRAP_FAILED = "[错误] PeerBanHelper 启动失败，遇到致命错误，请检查控制台日志";
    public static final String DATABASE_FAILURE = "[错误] 无法连接到持久化数据存储数据库，请检查是否同时启动了多个 PBH 示例？（如果 SQLite 数据库损坏，请删除它，PBH 将会重新生成新的数据库文件）";
    public static final String CONFIGURATION_OUTDATED_MODULE_DISABLED = "[警告] 无法确认功能模块 {} 的配置状态。配置文件似乎已过期，因此无法读取此模块的模块配置文件";
    public static final String BTN_DOWNLOADER_GENERAL_FAILURE = "[BTN 网络] 从下载器 {} 获取当前 Torrent 任务信息失败，跳过……";
    public static String BTN_PREPARE_TO_SUBMIT = "[BTN 网络] 已收集了 {} 个 Peer 信息，将分为 {} 次提交到 BTN 网络，感谢您对 BTN 网络做出的贡献";
    public static String BTN_UPDATE_RULES = "[BTN 网络] 正在连接到 BTN 网络服务器并更新规则数据，本地数据版本：{}";
    public static final String BTN_UPDATE_RULES_SUCCESSES = "[BTN 网络] 规则数据更新成功，当前数据版本：{}";
    public static final String BTN_REQUEST_FAILS = "[BTN 网络] 请求时出现错误，操作已取消 {}";
    public static final String BTN_CONFIG_FAILS = "[BTN 网络] 所连接的 BTN 网络实例未返回有效配置响应，BTN 网络功能可能不会正常工作 {}";
    public static final String MODULE_BTN_BAN = "[BTN 封禁] 匹配 %s 规则集（%s）：%s";
    public static final String BTN_NETWORK_CONNECTING = "[BTN 网络] 请等待我们连接到 BTN 网络……";
    public static final String BTN_NETWORK_NOT_ENABLED = "[BTN 网络] 未启用 BTN 功能：此 PeerBanHelper 客户端未加入 BTN 网络";
    public static final String BTN_NETWORK_ENABLED = "[BTN 网络] 功能已启用";
    public static String BTN_NETWORK_RECONFIGURED = "[BTN 网络] 服务器配置信息下发成功，已连接至 BTN 网络：{}";
    public static String PERSIST_CLEAN_LOGS = "[清理] 已成功清理 {} 条封禁日志";
    public static final String BANLIST_INVOKER_REGISTERED = "[BanListInvoker] 已注册：{}";
    public static final String BANLIST_INVOKER_IPFILTER_FAIL = "[BanListInvoker] 清空 ipfilter.dat 文件失败，出现 I/O 错误";
    public static final String BANLIST_INVOKER_COMMAND_EXEC_TIMEOUT = "[BanListInvoker] 执行命令 {} 时超时，PBH 不再继续等待进程";
    public static final String BANLIST_INVOKER_COMMAND_EXEC_FAILED = "[BanListInvoker] 执行命令 {} 时，进程返回非零状态码（{}），这可能意味着命令未被成功执行，请查看";
    public static String BAN_PEER_REVERSE_LOOKUP = "[DNS反向查找] IP 地址 {} 反向 DNS 记录为：{}";
    public static final String BTN_INCOMPATIBLE_SERVER = "[BTN 网络] 您所连接的 BTN 实例与当前 BTN 客户端不兼容";
    public static final String BTN_SUBMITTING_PEERS = "[BTN 网络] 计划任务正在向 BTN 网络提交目前下载的 Peers 列表，请稍等……";
    public static final String BTN_SUBMITTED_PEERS = "[BTN 网络] 已向 BTN 网络提交 {} 个 Peers，感谢您对 BTN 网络的支持！";
    public static final String BTN_SUBMITTING_BANS = "[BTN 网络] 计划任务正在向 BTN 网络提交自上次汇报以来新增的封禁条目，请稍等……";
    public static final String BTN_SUBMITTED_BANS = "[BTN 网络] 已向 BTN 网络提交 {} 个封禁记录，感谢您对 BTN 网络的支持！";
    public static final String BTN_SUBMITTING_HITRATE = "[BTN 网络] 计划任务正在向 BTN 网络回报规则命中率数据，请稍等";
    public static final String BTN_SUBMITTED_HITRATE = "[BTN 网络] 已向 BTN 网络回报 {} 个规则的命中率数据，感谢您对 BTN 网络的支持！";
    public static final String CONFIG_CHECKING = "[配置升级实用工具] 请等待检查配置文件更新……";
    public static final String CONFIG_MIGRATING = "[配置升级实用工具] 迁移配置文件：从 {} 至 {} ……";
    public static final String CONFIG_EXECUTE_MIGRATE = "[配置升级实用工具] 执行配置文件升级脚本：{}";
    public static final String CONFIG_MIGRATE_FAILED = "[配置升级实用工具] 执行配置文件升级脚本 {}（升级到版本 {}）时出现了错误，PeerBanHelper 可能无法正常运行：{}";
    public static final String CONFIG_UPGRADED = "[配置升级实用工具] 成功升级配置文件到版本 {}";
    public static final String CONFIG_SAVE_CHANGES = "[配置升级实用工具] 正在保存更改……";
    public static final String CONFIG_SAVE_ERROR = "[配置升级实用工具] 更改保存到磁盘失败";
    public static final String BTN_RECONFIGURE_CHECK_FAILED = "[BTN 网络] 检查重配置状态失败：{}";
    public static final String BTN_SHUTTING_DOWN = "[BTN 网络] 正在关闭 BTN 模块……";
    public static final String BTN_RECONFIGURING = "[BTN 网络] 发现服务器基本配置更新，正在重新配置 BTN 网络模块……";
    public static String RULE_ENGINE_PARSE_FAILED = "[规则引擎] 规则 {} 解析失败，解析过程中出现错误";
    public static String RULE_ENGINE_INVALID_RULE = "规则 {} 的参数 {} 无效，仅接受以下值：{}";
    public static String RULE_ENGINE_NOT_A_RULE = "[规则引擎] 表达式 {} 不是一个有效规则";
    public static final String RULE_MATCHER_STRING_CONTAINS = "子串匹配";
    public static final String RULE_MATCHER_STRING_ENDS_WITH = "匹配结尾";
    public static final String RULE_MATCHER_STRING_STARTS_WITH = "匹配开头";
    public static String RULE_MATCHER_STRING_EQUALS = "匹配相同";
    public static final String RULE_MATCHER_STRING_LENGTH = "匹配长度";
    public static final String RULE_MATCHER_STRING_REGEX = "匹配正则";
    public static final String RULE_MATCHER_SUB_RULE = "订阅规则";
    public static final String RESET_DOWNLOADER_FAILED = "[警告] 重置下载器封禁列表到初始状态时出现错误";
    public static final String DOWNLOADER_QB_INCREAMENT_BAN_FAILED = "[错误] 向下载器请求增量封禁对等体时出现错误，请在配置文件中关闭增量封禁(increment-ban)配置项";
    public static final String SHUTDOWN_CLOSE_METRICS = "[退出] 正在保存封禁日志和统计数据……";
    public static final String SHUTDOWN_UNREGISTER_MODULES = "[退出] 正在注销功能模块……";
    public static final String SHUTDOWN_CLOSE_DATABASE = "[退出] 正在安全关闭并保存持久化数据库……";
    public static final String SHUTDOWN_CLEANUP_RESOURCES = "[退出] 清理资源……";
    public static final String SHUTDOWN_DONE = "[退出] 全部完成！";
    public static final String SHUTDOWN_SAVE_BANLIST = "[退出] 正在保存封禁列表到本地缓存文件……";
    public static final String SHUTDOWN_SAVE_BANLIST_FAILED = "[退出] 保存封禁列表到文件失败";
    public static final String LOAD_BANLIST_FROM_FILE = "[封禁] 已从保存的封禁列表缓存文件中恢复了 {} 个封禁项";
    public static final String LOAD_BANLIST_FAIL = "[封禁] 加载封禁列表过程出现错误";

    public static final String GUI_MENU_WEBUI = "WebUI";
    public static final String GUI_MENU_WEBUI_OPEN = "打开 WebUI……";
    public static final String GUI_MENU_ABOUT = "关于";
    public static final String GUI_TRAY_MESSAGE_CAPTION = "PeerBanHelper 正在后台运行";
    public static final String GUI_TRAY_MESSAGE_DESCRIPTION = "点击托盘图标重新打开窗口；右键托盘图标可完全退出";
    public static final String GUI_TABBED_LOGS = "运行日志";
    public static final String GUI_TABBED_PEERS = "已连接的Peers";
    public static final String ABOUT_VIEW_GITHUB = "查看 Github 页面";
    public static final String IPDB_UPDATING = "{} 数据库已过期且需要更新，请等待 PBH 连接到 Maxmind 服务器更新数据……";
    public static final String IPDB_UPDATE_FAILED = "从 Maxmind 下载数据库 {} 时出现错误：{}";
    public static final String IPDB_UPDATE_SUCCESS = "从 Maxmind 更新数据库 {} 成功！";
    public static final String IPDB_INVALID = "由于在初始化过程中出现错误，IPDB 功能已被自动禁用。请检查日志文件以修复问题";
    public static final String IPDB_NEED_CONFIG = "IPDB 功能需要配置才能使用，请在 config.yml 的 ip-database 中填写相关配置信息";
    public static final String DOWNLOAD_PROGRESS_DETERMINED = "下载进度：已下载 {}/{} 字节，进度：{}%";
    public static final String DOWNLOAD_PROGRESS = "下载进度：已下载 {} 字节";
    public static final String DOWNLOAD_COMPLETED = "下载进度：已完成！共传输 {} 字节的数据";
    public static final String[] GUI_LIVE_PEERS_COLUMN_NAMES = {"国家/地区", "IP地址", "PeerID", "客户端", "汇报进度", "上传速度", "上传量", "下载速度", "下载量", "Torrent", "城市", "ASN", "AS组织", "AS网络"};
    public static final String BAN_WAVE_CHECK_COMPLETED = "已检查 {} 个下载器的 {} 个活跃 Torrent 与 {} 个 Peers。共封禁 {} 个 Peers，并解除 {} 个过期的封禁 ({}ms)";
    public static final String WATCH_DOG_HUNGRY = "[警告] WatchDog Service {} 未在指定时间 {} 内得到重置，最后状态 {}，正在转储进程线程信息，请发送给 PeerBanHelper 开发者以协助修复此问题";
    public static final String WATCH_DOG_CALLBACK_BLOCKED = "[错误] WatchDog Service 回调线程无响应，已强制离开回调";
    public static final String PBH_BAN_WAVE_STARTED = "PeerBanHelper BanWave Daemon 已启动";
    public static final String BAN_WAVE_WATCH_DOG_TITLE = "PeerBanHelper 正尝试从异常中恢复";
    public static final String BAN_WAVE_WATCH_DOG_DESCRIPTION = "我们检测到封禁线程因未知原因停止响应，因此 PeerBanHelper 已尝试重启问题线程。请查看程序日志并将有关信息发送给开发者以协助修复此错误。";
    public static final String INTERNAL_ERROR = "出现了一个内部错误，请检查控制台日志";
    public static final String PART_TASKS_TIMED_OUT = "[警告] 等待部分任务执行时超过最大时间限制，忽略未完成的任务…… 当前执行：{}";
    public static final String TOO_WEAK_TOKEN = "Web Auth Token 未初始化或不满足最低强度要求（长度 > 8），PeerBanHelper 已重新生成了一个满足复杂度的新 Token";
    public static final String TIMING_RECOVER_PERSISTENT_BAN_LIST = "[超时] 在恢复持久化封禁列表到下载器时出现操作超时，任务已被强制终止";
    public static final String TIMING_CHECK_BANS = "[超时] 在执行 Peers 检查时出现操作超时，任务已被强制终止";
    public static final String TIMING_ADD_BANS = "[超时] 在处理新增 Peers 封禁时出现操作超时，任务已被强制终止";
    public static final String TIMING_APPLY_BAN_LIST = "[超时] 在应用封禁列表到下载器时出现操作超时，任务已被强制终止";
    public static final String TIMING_COLLECT_PEERS = "[超时] 在请求下载器 WebAPI 以获取已连接的 Peers 时操作超时，任务已被强制终止，建议检查下载器状态和网络连接。";
    public static final String TIMING_UNFINISHED_TASK = "[超时] 未完成的任务已被强制终止 -> {}";
    public static final String CONFIGURATION_INVALID = "[错误] 配置文件加载失败，可能由于人为修改错误或设备异常断电导致损坏，请删除文件 {} 来重置配置文件";
    public static final String CONFIGURATION_INVALID_TITLE = "配置文件加载失败";
    public static final String CONFIGURATION_INVALID_DESCRIPTION = "PeerBanHelper 无法正确加载必要的配置文件，这可能由于人为修改错误或设备异常断电导致损坏，请删除文件 %s 来重置配置文件。\nPeerBanHelper 即将退出……";
}
