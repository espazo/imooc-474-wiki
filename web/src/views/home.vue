<template>
  <a-layout>
    <a-layout-sider style="background: #fff" width="200">
      <a-menu
          :style="{ height: '100%', borderRight: 0 }"
          mode="inline"
          @click="handleClick"
      >
        <a-menu-item key="welcome">
          <MailOutlined/>
          <span>欢迎</span>
        </a-menu-item>
        <a-sub-menu v-for="item in level1" :key="item.id">
          <template v-slot:title>
            <span><user-outlined/>{{ item.name }}</span>
          </template>
          <a-menu-item v-for="child in item.children" :key="child.id">
            <MailOutlined/>
            <span>{{ child.name }}</span>
          </a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <div v-show="isShowWelcome" class="welcome">
        <h1>欢迎使用知识库</h1>
      </div>
      <a-list v-show="!isShowWelcome" :data-source="ebooks" :grid="{ gutter: 20, column: 3 }" item-layout="vertical"
              size="large">
        <template #renderItem="{ item }">
          <a-list-item key="item.name">
            <template #actions>
          <span v-for="{ type, text } in actions" :key="type">
            <component v-bind:is="type" style="margin-right: 8px"/>
            {{ text }}
          </span>
            </template>
            <a-list-item-meta :description="item.description">
              <template #title>
                <router-link :to="'/doc?ebookId=' + item.id">
                  {{ item.name }}
                </router-link>
              </template>
              <template #avatar>
                <a-avatar :src="item.cover"/>
              </template>
            </a-list-item-meta>
          </a-list-item>
        </template>
      </a-list>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from 'vue';
import axios from 'axios';
import {message} from 'ant-design-vue';
import {Tool} from '@/util/tool'

// const listData: any = []
// for (let i = 0; i < 23; i++) {
//   listData.push({
//     href: 'https://www.antdv.com/',
//     title: `ant design vue part ${i}`,
//     avatar: 'https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png',
//     description:
//         'Ant Design, a design language for background applications, is refined by Ant UED Team.',
//     content:
//         'We supply a series of design principles, practical patterns and high quality design resources (Sketch and Axure), to help people create their product prototypes beautifully and efficiently.',
//   });
// }

export default defineComponent({
  name: 'Home',
  setup() {

    const ebooks = ref();
    // const ebooks1 = reactive({books: []});

    const level1 = ref();
    let categorys: any;

    /**
     * 查询所有分类
     */
    const handleQueryCategory = () => {
      axios.get('/category/all').then((response) => {
        const data = response.data;
        if (data.success) {
          categorys = data.content;
          console.log('原始数组：', categorys);

          level1.value = []
          level1.value = Tool.array2Tree(categorys, 0);
          console.log('树形结构：', level1.value);
        } else {
          message.error(data.message);
        }
      });
    };

    const isShowWelcome = ref(true);
    let category2 = 0;

    const handleQueryEbook = () => {
      axios.get('/ebook/list', {
        params: {
          page: 1,
          size: 1000,
          categoryId2: category2,
        }
      }).then((response) => {
        const data = response.data;
        ebooks.value = data.content.list;
        // ebooks1.books = data.content;
      });
    };

    const handleClick = (value: any) => {
      // console.log("menu click", value);
      if (value.key === 'welcome') {
        isShowWelcome.value = true;
      } else {
        isShowWelcome.value = false;
        category2 = value.key;
        handleQueryEbook();
      }
      // isShowWelcome.value = value.key === 'welcome';
    };

    onMounted(() => {
      handleQueryCategory();
      // handleQueryEbook();
    });

    return {
      ebooks,
      // ebooks2: toRef(ebooks1, "books"),
      // listData,
      pagination: {
        onChange: (page: any) => {
          console.log(page);
        },
        pageSize: 3,
      },
      actions: [
        {type: 'StarOutlined', text: '156'},
        {type: 'LikeOutlined', text: '156'},
        {type: 'MessageOutlined', text: '2'}
      ],

      handleClick,
      level1,

      isShowWelcome,
    }
  }
});
</script>

<style scoped>
.ant-avatar {
  width: 50px;
  height: 50px;
  line-height: 50px;
  border-radius: 8%;
  margin: 5px 0;
}
</style>
