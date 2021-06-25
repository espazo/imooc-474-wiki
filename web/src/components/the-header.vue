<template>
  <a-layout-header class="header">
    <div class="logo"/>
    <a-menu
        :style="{ lineHeight: '64px' }"
        mode="horizontal"
        theme="dark"
    >
      <a-menu-item key="/">
        <router-link to="/">房产信息管理系统</router-link>
      </a-menu-item>
      <a-menu-item v-if="visible" key="/admin/ebook">
        <router-link to="/admin/ebook">房产管理</router-link>
      </a-menu-item>
      <a-menu-item v-if="!visible" key="/about">
        <router-link to="/about">登录</router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-header>
</template>

<script lang="ts">
import {defineComponent, ref} from 'vue';
import {useStore} from "vuex";

export default defineComponent({
  name: 'the-header',
  setup() {
    const store = useStore();
    const visible = ref(false);
    const si = setInterval(function () {
      visible.value = store.state.visible;
      console.log(visible.value);
      if (visible.value) {
        clearInterval(si);
      }
    }, 1000);
    return {
      visible
    }
  },
});
</script>
