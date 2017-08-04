<template>
  <el-row class="panel" :class="{'mini-menu': isMiniMenu}">
    <!-- 顶部区域 -->
    <el-col :span="24" class="panel-top">
      <el-col :span="8">
        <span class="logo"></span>
      </el-col>
      <el-col :span="16">
        <span class="list" @click="logout"><i class="iconfont icon-logout"></i> 退出</span>
        <span class="list">
          Hi, {{userName}}
        </span>
      </el-col>
    </el-col>
    <el-col :span="24" class="panel-center">
      <!-- 左侧菜单栏 -->
      <aside class="main-menu">
        <div class="main-menu-list">
          <!-- 默认选中哪个菜单 -- default-active="0-0" -->
          <el-menu class="menu" @select="handleselect" theme="dark" unique-opened>
            <template v-for="(item,indexParent) in menu">
              <el-menu-item :index="indexParent"
                            @click.native="selected(item.moduleName,item.moduleId)">
                <i class="el-icon-message"></i>
                <span slot="title">{{item.title}}</span>
              </el-menu-item>
            </template>
          </el-menu>
        </div>
        <i class="el-icon-d-arrow-left menu-expand" @click='switchMenu'></i>
      </aside>
      <!-- 主体内容区域 -->
      <section class="panel-container">
        <div class="grid-content">
          <el-tabs type="card" closable
                   @tab-click="handleClick"
                   @tab-remove="handleRemove"
                   :active-name="tab"
                   class="outer-tabs">
            <el-tab-pane v-for="(item, index) in tabs" :label="item.title" :name="item.title">
              <div :is="item.content" @page="createTab" @close="handleRemove" :tab-name="tab"></div>
            </el-tab-pane>
          </el-tabs>
        </div>
      </section>
    </el-col>
  </el-row>
</template>

<script>
  import axios from 'axios';

  import homePage from './components/hello';//homePage;

  import Chat from './components/chat';
  import Counter from './components/counter';
  import Foo from './components/foo';

  export default {
    data() {
      return {
        isMiniMenu: false,
        tabs: [{
          title: '首页',
          name: '首页',
          content: 'homePage',
          btns: {}
        }],
        tab: '首页',
        menu: [],
        menuComponent: {
          '首页': 'homePage',
          'Chat': 'chat',
          'Counter': 'counter',
          'Foo': 'foo'
        },
        openedElement: [],
        userName: 'srw962'
      }
    },
    beforeCreate() {
      axios.post('/getMenu', {
        userName: this.userName
      }).then(response => {
        this.menu = response.data;
      }).catch(error => {
        //self.message = 'Error: ' + error.response.status;
      });
    },
    mounted() {
    },
    computed: {},
    methods: {
      queryBtns(moduleId, tabObjIntabs) {
      },
      switchMenu() {
        this.isMiniMenu = !this.isMiniMenu
        if (!this.isMiniMenu) {
          var ele = this.$el.querySelector(".el-menu--dark").children
          var openedElement
          for (let sub of ele) {
            if (sub.className.indexOf('is-opened') != -1) {
              openedElement = sub
              break
            }
          }
        }
      },
      renderTab(h, tab) {
        return h('span', [
          `${tab.title} `,
          h('i', {
            class: ['el-icon-close']
          })
        ])
      },
      handleselect: function (a, b, c) {
      },
      selected(tab, moduleId) {
        for (let [index, item] of this.tabs.entries()) {
          if (item.title == tab) {
            this.tab = tab;
            return;
          }
        }
        var content = this.menuComponent[tab];
        this.tabs.push({
          'title': tab,
          'name': tab,
          'content': content
        });
        this.tab = tab;
      },
      handleClick(tab, event) {
        this.tab = tab.name
      },
      handleRemove(targetName) {
        let tabs = this.tabs;
        let activeName = this.tab;
        if (activeName === targetName) {
          tabs.forEach((tab, index) => {
            if (tab.name === targetName) {
              let nextTab = tabs[index + 1] || tabs[index - 1];
              if (nextTab) {
                activeName = nextTab.name;
              }
            }
          });
        }

        this.tab = activeName;
        this.tabs = tabs.filter(tab => tab.name !== targetName);
      },
      over(event) {
        var panel = this.$el.querySelector(".panel-top").parentNode
        if (panel.className.indexOf('mini-menu') != -1) {
          event.currentTarget.querySelector(".el-menu").style.display = 'block'
        }
      },
      out(event) {
        var panel = this.$el.querySelector(".panel-top").parentNode
        if (panel.className.indexOf('mini-menu') != -1) {
          event.currentTarget.querySelector(".el-menu").style.display = 'none'
        }
      },
      logout() {
      },
      createTab(t, c) {
        let flag = false;
        for (let [index, item] of this.tabs.entries()) {
          if (item.title == t) {
            this.tabs.splice(index, 1, {
              'title': t,
              'name': t,
              'content': c
            });
            flag = true;
            break
          }
        }
        if (!flag) {
          this.tabs.push({
            'title': t,
            'name': t,
            'content': c
          })
        }
        this.tab = t
      }
    },
    components: {
      homePage: homePage,

      chat: Chat,
      counter: Counter,
      foo: Foo
    }
  }
</script>
