package com.ghostchu.peerbanhelper.module.impl.webapi;

import com.ghostchu.peerbanhelper.metric.BasicMetrics;
import com.ghostchu.peerbanhelper.metric.HitRateMetricRecorder;
import com.ghostchu.peerbanhelper.module.AbstractFeatureModule;
import com.ghostchu.peerbanhelper.text.TranslationComponent;
import com.ghostchu.peerbanhelper.util.rule.Rule;
import com.ghostchu.peerbanhelper.web.JavalinWebContainer;
import com.ghostchu.peerbanhelper.web.Role;
import com.ghostchu.peerbanhelper.wrapper.BanMetadata;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ghostchu.peerbanhelper.text.TextManager.tl;

@Component
public class PBHMetricsController extends AbstractFeatureModule {
    @Autowired
    @Qualifier("persistMetrics")
    private BasicMetrics metrics;
    @Override
    public boolean isConfigurable() {
        return false;
    }

    @Autowired
    private JavalinWebContainer webContainer;

    @Override
    public void onEnable() {
        webContainer.javalin()
                .get("/api/statistic/counter", this::handleBasicCounter, Role.USER_READ)
                .get("/api/statistic/rules", this::handleRules, Role.USER_READ);
    }

    private void handleRules(Context ctx) {
        String locale = locale(ctx);
        Map<Rule, HitRateMetricRecorder> metric = new HashMap<>(getServer().getHitRateMetric().getHitRateMetric());
        Map<String, String> dict = new HashMap<>();
        List<RuleData> dat = metric.entrySet().stream()
                .map(obj -> {
                    TranslationComponent ruleType = new TranslationComponent(obj.getKey().getClass().getName());
                    if (obj.getKey().matcherName() != null) {
                        ruleType = obj.getKey().matcherName();
                    }
                    dict.put(obj.getKey().matcherIdentifier(), tl(locale, ruleType));
                    return new RuleData(obj.getKey().matcherIdentifier(), obj.getValue().getHitCounter(), obj.getValue().getQueryCounter(), obj.getKey().metadata());
                })
                .sorted((o1, o2) -> Long.compare(o2.getHit(), o1.getHit()))
                .toList();
        Map<String, Object> resp = new HashMap<>();
        resp.put("dict", dict);
        resp.put("data", dat);
        ctx.status(HttpStatus.OK);
        ctx.json(resp);
    }

    private void handleBasicCounter(Context ctx) {
        Map<String, Object> map = new HashMap<>();
        map.put("checkCounter", metrics.getCheckCounter());
        map.put("peerBanCounter", metrics.getPeerBanCounter());
        map.put("peerUnbanCounter", metrics.getPeerUnbanCounter());
        map.put("banlistCounter", getServer().getBannedPeers().size());
        ctx.status(HttpStatus.OK);
        ctx.json(map);
    }

    @Override
    public void onDisable() {
        this.metrics = null;
    }

    @Override
    public @NotNull String getName() {
        return "WebAPI - Metrics";
    }

    @Override
    public @NotNull String getConfigName() {
        return "webapi-metrics";
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class BanResponse {
        private String address;
        private BanMetadata banMetadata;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class RuleData {
        private String type;
        private long hit;
        private long query;
        private Map<String, Object> metadata;
    }

}
