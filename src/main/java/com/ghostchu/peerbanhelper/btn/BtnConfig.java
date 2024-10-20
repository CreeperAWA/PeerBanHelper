package com.ghostchu.peerbanhelper.btn;

import com.ghostchu.peerbanhelper.PeerBanHelperServer;
import com.ghostchu.peerbanhelper.text.Lang;
import com.ghostchu.peerbanhelper.util.rule.ModuleMatchCache;
import lombok.extern.slf4j.Slf4j;
import org.bspfsystems.yamlconfiguration.configuration.ConfigurationSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ghostchu.peerbanhelper.text.TextManager.tlUI;

@Configuration
@Slf4j
public class BtnConfig {
    @Autowired
    private PeerBanHelperServer server;
    @Autowired
    @Qualifier("userAgent")
    private String userAgent;
    @Autowired
    private ModuleMatchCache matchCache;

    @Bean
    public BtnNetwork btnNetwork() {
        ConfigurationSection section = server.getMainConfig().getConfigurationSection("btn");
        if (section.getBoolean("enabled")) {
            log.info(tlUI(Lang.BTN_NETWORK_CONNECTING));
            var configUrl = server.getMainConfig().getString("btn.config-url");
            var submit = server.getMainConfig().getBoolean("btn.submit");
            var appId = server.getMainConfig().getString("btn.app-id");
            var appSecret = server.getMainConfig().getString("btn.app-secret");
            BtnNetwork btnNetwork = new BtnNetwork(server, userAgent, configUrl, submit, appId, appSecret, matchCache);
            log.info(tlUI(Lang.BTN_NETWORK_ENABLED));
            return btnNetwork;
        } else {
            log.info(tlUI(Lang.BTN_NETWORK_NOT_ENABLED));
            return null;
        }
    }
}
