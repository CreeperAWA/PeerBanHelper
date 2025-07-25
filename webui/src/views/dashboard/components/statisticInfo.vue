<template>
  <a-space direction="vertical" fill>
    <a-card :title="t('page.dashboard.statics.currentStatus')" hoverable>
      <a-grid :cols="24" :row-gap="16" class="panel">
        <a-grid-item class="panel-col" :span="{ xs: 12, sm: 12, md: 6 }">
          <a-statistic
            :title="t('page.dashboard.statics.checked')"
            :value="current?.checkCounter"
            :value-from="previous.checkCounter"
            animation
            show-group-separator
          >
            <template #suffix>
              <a-typography-text
                >{{ t('page.dashboard.statics.times') }}
              </a-typography-text></template
            >
          </a-statistic>
        </a-grid-item>
        <a-grid-item class="panel-col" :span="{ xs: 12, sm: 12, md: 6 }">
          <a-statistic
            :title="t('page.dashboard.statics.banPeer')"
            :value="current?.peerBanCounter"
            :value-from="previous.peerBanCounter"
            animation
            show-group-separator
          >
            <template #suffix
              ><a-typography-text>{{ t('page.dashboard.statics.times') }} </a-typography-text>
            </template>
          </a-statistic>
        </a-grid-item>
        <a-grid-item class="panel-col" :span="{ xs: 12, sm: 12, md: 6 }">
          <a-statistic
            :title="t('page.dashboard.statics.unbanPeer')"
            :value="current?.peerUnbanCounter"
            :value-from="previous.peerUnbanCounter"
            animation
            show-group-separator
          >
            <template #suffix>
              <a-typography-text>{{ t('page.dashboard.statics.times') }} </a-typography-text>
            </template>
          </a-statistic>
        </a-grid-item>
        <a-grid-item class="panel-col" :span="{ xs: 12, sm: 12, md: 6 }">
          <a-statistic
            :title="t('page.dashboard.statics.currentBanIps')"
            :value="current?.bannedIpCounter"
            :value-from="previous.bannedIpCounter"
            animation
            show-group-separator
          >
            <template #suffix>
              <a-typography-text>{{ t('page.dashboard.statics.number') }} </a-typography-text>
            </template>
          </a-statistic>
        </a-grid-item>

        <a-grid-item class="panel-col" :span="{ xs: 12, sm: 12, md: 6 }">
          <a-statistic
            :title="t('page.dashboard.statics.peerBlockRate')"
            :value="formatPercentage(current?.peersBlockRate)"
            :value-from="formatPercentage(previous.peersBlockRate)"
            :precision="2"
            animation
            show-group-separator
          >
            <template #suffix>
              <a-typography-text>{{ t('page.dashboard.statics.percentage') }} </a-typography-text>
            </template>
          </a-statistic>
        </a-grid-item>
        <a-grid-item class="panel-col" :span="{ xs: 12, sm: 12, md: 6 }">
          <a-statistic
            :title="t('page.dashboard.statics.trackingPeers')"
            :value="current?.trackedSwarmCount"
            :value-from="previous.trackedSwarmCount"
            animation
            show-group-separator
          >
            <template #suffix>
              <a-typography-text>{{ t('page.dashboard.statics.number') }} </a-typography-text>
            </template>
          </a-statistic>
        </a-grid-item>
      </a-grid>
    </a-card>
  </a-space>
</template>
<script setup lang="ts">
import type { Statistic } from '@/api/model/statistic'
import { getStatistic } from '@/service/downloaders'
import { useAutoUpdatePlugin } from '@/stores/autoUpdate'
import { useEndpointStore } from '@/stores/endpoint'
import { isEqual } from 'lodash'
import { ref, watch } from 'vue'
import { useI18n } from 'vue-i18n'
import { useRequest } from 'vue-request'
const { t } = useI18n()
const endpointStore = useEndpointStore()
const previous = ref<Statistic>({
  checkCounter: 0,
  peerBanCounter: 0,
  peerUnbanCounter: 0,
  banlistCounter: 0,
  bannedIpCounter: 0,
  trackedSwarmCount: 0,
  peersBlockRate: 0,
  wastedTraffic: 0
})
const current = ref<Statistic>(previous.value)
const { refresh } = useRequest(
  getStatistic,
  {
    onSuccess: (data) => {
      const tempPrevious = current.value
      current.value = data.data // 先刷新
      if (!isEqual(data, tempPrevious)) previous.value = tempPrevious
    },
    cacheKey: () => `${endpointStore.endpoint}-statistic`
  },
  [useAutoUpdatePlugin]
)

watch(() => endpointStore.endpoint, refresh)

const formatPercentage = (value: number | undefined): number => {
  if (value === undefined || value === null) return 0
  return Number((value * 100.0).toFixed(2))
}
</script>
