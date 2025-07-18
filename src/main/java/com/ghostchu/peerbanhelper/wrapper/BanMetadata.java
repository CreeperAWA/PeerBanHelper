package com.ghostchu.peerbanhelper.wrapper;

import com.ghostchu.peerbanhelper.bittorrent.peer.Peer;
import com.ghostchu.peerbanhelper.bittorrent.torrent.Torrent;
import com.ghostchu.peerbanhelper.downloader.DownloaderBasicInfo;
import com.ghostchu.peerbanhelper.text.TranslationComponent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class BanMetadata extends PeerMetadata implements Serializable {
    private String context;
    private String randomId;
    private long banAt;
    private long unbanAt;
    private boolean banForDisconnect;
    private TranslationComponent rule;
    private TranslationComponent description;
    private StructuredData<String, Object> structuredData;

    public BanMetadata(String context, String randomId, DownloaderBasicInfo downloader, long banAt, long unbanAt, boolean banForDisconnect, Torrent torrent, Peer peer, TranslationComponent rule,
                       TranslationComponent description, StructuredData<String, Object> structuredData) {
        super(downloader, torrent, peer);
        this.context = context;
        this.randomId = randomId;
        this.banAt = banAt;
        this.unbanAt = unbanAt;
        this.banForDisconnect = banForDisconnect;
        this.rule = rule;
        this.description = description;
        this.structuredData = structuredData;
    }

    public BanMetadata(String context, String randomId, DownloaderBasicInfo downloader, long banAt, long unbanAt, boolean banForDisconnect, TorrentWrapper torrent, PeerWrapper peer, TranslationComponent rule,
                       TranslationComponent description, StructuredData<String, Object> structuredData) {
        super(downloader, torrent, peer);
        this.context = context;
        this.randomId = randomId;
        this.banAt = banAt;
        this.unbanAt = unbanAt;
        this.banForDisconnect = banForDisconnect;
        this.rule = rule;
        this.description = description;
        this.structuredData = structuredData;
    }

    @Override
    public String toString() {
        return "BanMetadata{" +
                "context='" + context + '\'' +
                ", banAt=" + banAt +
                ", unbanAt=" + unbanAt +
                ", banForDisconnect=" + banForDisconnect +
                ", rule=" + rule +
                ", description=" + description +
                '}';
    }
}
