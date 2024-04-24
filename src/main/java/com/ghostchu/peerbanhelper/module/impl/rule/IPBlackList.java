package com.ghostchu.peerbanhelper.module.impl.rule;

import com.ghostchu.peerbanhelper.PeerBanHelperServer;
import com.ghostchu.peerbanhelper.module.AbstractFeatureModule;
import com.ghostchu.peerbanhelper.module.BanResult;
import com.ghostchu.peerbanhelper.module.PeerAction;
import com.ghostchu.peerbanhelper.peer.Peer;
import com.ghostchu.peerbanhelper.text.Lang;
import com.ghostchu.peerbanhelper.torrent.Torrent;
import com.ghostchu.peerbanhelper.wrapper.PeerAddress;
import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;
import org.bspfsystems.yamlconfiguration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class IPBlackList extends AbstractFeatureModule {
    private List<IPAddress> ips;
    private List<Integer> ports;

    public IPBlackList(PeerBanHelperServer server, YamlConfiguration profile) {
        super(server, profile);
    }

    @Override
    public @NotNull String getName() {
        return "IP Blacklist";
    }

    @Override
    public @NotNull String getConfigName() {
        return "ip-address-blocker";
    }

    @Override
    public boolean needCheckHandshake() {
        return false;
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public void onEnable() {
        reloadConfig();
    }

    @Override
    public void onDisable() {

    }

    private void reloadConfig() {
        this.ips = new ArrayList<>();
        for (String s : getConfig().getStringList("ips")) {
            IPAddress ipAddress = new IPAddressString(s).getAddress();
            if (ipAddress != null) {
                this.ips.add(ipAddress);
            }
        }
        this.ports = getConfig().getIntList("ports");
    }

    @Override
    public @NotNull BanResult shouldBanPeer(@NotNull Torrent torrent, @NotNull Peer peer, @NotNull ExecutorService ruleExecuteExecutor) {
        PeerAddress peerAddress = peer.getAddress();
        if (ports.contains(peerAddress.getPort())) {
            return new BanResult(this, PeerAction.BAN, String.format(Lang.MODULE_IBL_MATCH_PORT, peerAddress.getPort()));
        }
        IPAddress pa = new IPAddressString(peerAddress.getIp()).getAddress();
        if (pa == null) {
            return new BanResult(this, PeerAction.NO_ACTION, "Peer Address is null");
        }
        if (pa.isIPv4Convertible()) {
            pa = pa.toIPv4();
        }
        for (IPAddress ra : ips) {
            if (ra.equals(pa) || ra.contains(pa)) {
                return new BanResult(this, PeerAction.BAN, String.format(Lang.MODULE_IBL_MATCH_IP, ip));
            }
        }
        return new BanResult(this, PeerAction.NO_ACTION, "No matches");
    }


}
