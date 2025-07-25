<template>
  <a-space direction="vertical" class="container" size="medium">
    <a-form :disabled="loading" :model="options" layout="inline">
      <a-form-item field="autoRefresh" :label="t('page.settings.tab.info.log.enableAutoRefresh')">
        <a-switch v-model="options.autoRefresh" :before-change="changeAutoRefresh" />
      </a-form-item>
      <a-form-item
        v-if="options.autoRefresh"
        field="autoScroll"
        :label="t('page.settings.tab.info.log.autoScorll')"
      >
        <a-switch v-model="options.autoScroll" />
      </a-form-item>
      <a-form-item field="showThreadName" :label="t('page.settings.tab.info.log.showThread')">
        <a-switch v-model="showThreadName" />
      </a-form-item>
      <a-form-item field="showLevel" :label="t('page.settings.tab.info.log.showLevel')">
        <a-space>
          <a-tag
            v-for="level of Object.keys(options.showLevel) as LogLevel[]"
            :key="level"
            v-model:checked="options.showLevel[level]"
            :color="getColorByLogLevel(level)"
            checkable
          >
            {{ level }}</a-tag
          >
        </a-space>
      </a-form-item>
      <a-form-item field="hideThreads" :label="t('page.settings.tab.info.log.hideThreads')">
        <a-select
          v-model="options.hideThreads"
          :placeholder="t('page.settings.tab.info.log.hideThreads.placeholder')"
          :style="{ width: '15rem' }"
          multiple
          :max-tag-count="1"
          allow-create
          scrollbar
          :options="threadList"
        />
      </a-form-item>
    </a-form>
    <a-list
      ref="logList"
      size="small"
      :loading="loading"
      scrollbar
      :virtual-list-props="{
        height: 650,
        buffer: 50
      }"
      :data="list"
    >
      <template #item="{ item, index }">
        <a-list-item :key="index">
          <a-row class="log-line-container" justify="end" :wrap="false">
            <a-col flex="auto">
              <a-row class="log-line" :wrap="false" justify="start" :gutter="10">
                <a-col flex="24px">
                  <a-tag class="level-tag" :color="getColorByLogLevel(item.level)">{{
                    item.level
                  }}</a-tag>
                </a-col>
                <a-col flex="120px">
                  <a-tag>{{ d(item.time, 'log') }}</a-tag>
                </a-col>
                <a-col v-if="showThreadName" flex="1">
                  <a-tag :color="getThreadColor(item.thread)">
                    {{ item.thread }}
                  </a-tag>
                </a-col>
                <a-col :flex="showThreadName ? 8 : 9" claass="log-line">
                  <a-typography-text
                    style="flex: 1; width: 100%"
                    :ellipsis="{
                      rows: 1,
                      showTooltip: true
                    }"
                    >{{ item.content }}
                  </a-typography-text>
                </a-col>
              </a-row>
            </a-col>
            <a-col flex="20px">
              <div class="hover-display-btn">
                <copier :text="item.content" />
              </div>
            </a-col>
          </a-row>
        </a-list-item>
      </template>
    </a-list>
  </a-space>
</template>
<script setup lang="ts">
import { LogLevel, type Log } from '@/api/model/log'
import copier from '@/components/copier.vue'
import { GetHistoryLogs, StreamLogger } from '@/service/logger'
import { getColor } from '@/utils/color'
import { List, Message, type SelectOptionData } from '@arco-design/web-vue'
import { computed, onBeforeUnmount, reactive, ref } from 'vue'
import { useI18n } from 'vue-i18n'
import { useRequest } from 'vue-request'
const { t, d } = useI18n()
const loading = ref(true)
const options = reactive({
  hideThreads: [] as string[],
  autoScroll: true,
  autoRefresh: false,
  showLevel: {
    [LogLevel.TRACE]: false,
    [LogLevel.DEBUG]: false,
    [LogLevel.INFO]: true,
    [LogLevel.WARN]: true,
    [LogLevel.ERROR]: true
  }
})

const threadList = computed((): SelectOptionData[] =>
  Array.from(modules.value).map((it) => ({
    value: it,
    tagProps: { color: getThreadColor(it) }
  }))
)
const modules = ref(new Set<string>())
const logBuffer = ref([] as Log[])
useRequest(GetHistoryLogs, {
  onSuccess: (data) => {
    logBuffer.value.splice(0, logBuffer.value.length)
    logBuffer.value.push(...data.data)
    loading.value = false
    // calculate modules
    data.data.forEach((log) => modules.value.add(log.thread))
  }
})

const list = computed(() =>
  logBuffer.value
    .filter((log) => options.showLevel[log.level])
    .filter((log) => !options.hideThreads.includes(log.thread))
)

const logList = ref<typeof List>()
const ws = new StreamLogger()
const changeAutoRefresh = async (enable: boolean | string | number) => {
  try {
    if (enable) {
      console.log('open auto refresh')
      return ws.open(
        logBuffer.value.length > 0 ? logBuffer.value[logBuffer.value.length - 1].offset : 0,
        (newLog) => {
          logBuffer.value.push(newLog)
          modules.value.add(newLog.thread)
          console.log('scroll to', logBuffer.value.length - 1)
          if (options.autoScroll) {
            logList.value?.scrollIntoView({
              index: logBuffer.value.length - 1,
              align: 'bottom'
            } as ScrollIntoViewOptions)
          }
        },
        (err) => {
          Message.error(err.message)
          options.autoRefresh = false
        }
      )
    } else {
      ws.close()
      return true
    }
  } catch (e) {
    if (e instanceof Error) Message.error(e.message)
    return false
  }
}

const getColorByLogLevel = (level: LogLevel) => {
  switch (level) {
    case LogLevel.TRACE:
      return 'blue'
    case LogLevel.WARN:
      return 'orange'
    case LogLevel.ERROR:
      return 'red'
    case LogLevel.DEBUG:
    case LogLevel.INFO:
    default:
      return 'gray'
  }
}

const getThreadColor = (thread: string) => {
  if (thread.startsWith('virtual-') || thread.startsWith('pool') || /Thread-[0-9]+/.test(thread)) {
    return 'gray'
  } else {
    return getColor(thread, ['orange', 'orangered', 'red', 'blue'])
  }
}

onBeforeUnmount(() => {
  console.log('close ws')
  ws.close()
})

const showThreadName = ref(false)
</script>

<style scoped>
.container {
  width: 70rem;
}
.level-tag {
  width: 4.5em;
  text-align: center;
  display: flex;
  justify-content: center;
}
</style>

<style lang="less">
.log-line {
  .arco-typography {
    max-width: 50rem;
    margin-bottom: 0;
  }
}
.hover-display-btn {
  transition: opacity 0.15s ease-in-out;
  opacity: 0;
}

.log-line-container:hover .hover-display-btn {
  transition: opacity 0.15s ease-in-out;
  opacity: 1;
}
</style>
