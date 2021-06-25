<template>
  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <a-form :model="param">
        <a-form-item>
          <a-input v-model:value="param.account" placeholder="名称">
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-input type="password" v-model:value="param.password" placeholder="密码">
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-button type="primary" @click="submit">
            登录
          </a-button>
        </a-form-item>
      </a-form>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import {defineComponent, ref} from 'vue';
import axios from 'axios';
import {message} from 'ant-design-vue'
import {useStore} from "vuex";

export default defineComponent({
  name: 'About',
  setup() {
    const param = ref({
      account: "",
      password: "",
    });

    const store = useStore();

    const submit = () => {
      axios.post('/login', param.value).then((response) => {
        const data = response.data;
        console.log(data);
        if (data.success) {
          message.info("登录成功");
          store.state.visible = true;
          console.log("success");
        } else {
          message.error("用户名或者密码错误")
          store.state.visible = false;
          console.error("error");
        }
      });
    };

    return {
      param,
      submit
    }
  }
});
</script>
