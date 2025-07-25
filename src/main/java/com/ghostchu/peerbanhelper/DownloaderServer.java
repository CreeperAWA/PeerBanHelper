package com.ghostchu.peerbanhelper;

import com.ghostchu.peerbanhelper.bittorrent.peer.Peer;
import com.ghostchu.peerbanhelper.bittorrent.torrent.Torrent;
import com.ghostchu.peerbanhelper.wrapper.BanMetadata;
import com.ghostchu.peerbanhelper.wrapper.PeerAddress;
import com.ghostchu.peerbanhelper.wrapper.PeerMetadata;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public interface DownloaderServer {
    @NotNull Map<PeerAddress, BanMetadata> getBannedPeers();

    @NotNull Map<PeerAddress, BanMetadata> getBannedPeersDirect();

    @NotNull Map<PeerAddress, List<PeerMetadata>> getPeerSnapshot();

    void scheduleBanPeer(@NotNull BanMetadata banMetadata, @NotNull Torrent torrent, @NotNull Peer peer);

    void scheduleUnBanPeer(@NotNull PeerAddress peer);

    Map<PeerAddress, List<PeerMetadata>> getLivePeersSnapshot();

    void setGlobalPaused(boolean globalPaused);

    inet.ipaddr.format.util.DualIPv4v6Tries getIgnoreAddresses();

    long getBanDuration();

    boolean isHideFinishLogs();

    java.util.concurrent.atomic.AtomicBoolean getNeedReApplyBanList();

    boolean isGlobalPaused();
}
