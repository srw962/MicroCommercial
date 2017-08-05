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
          <el-menu class="menu" @select="handleselect" theme="dark" :router="true" unique-opened>
            <template v-for="(item,indexParent) in menu">
              <el-menu-item :index="indexParent.toString()"
                            :route="{ name: item.moduleName }">
                <i class="el-icon-message"></i>
                {{item.title}}
              </el-menu-item>
            </template>
          </el-menu>
        </div>
        <i class="el-icon-d-arrow-left menu-expand" @click='switchMenu'></i>
      </aside>

      <!-- 主体内容区域 -->
      <section class="panel-container">
        <div>
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item v-for="(item, index) in $route.meta" key="index">{{item}}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <transition mode="out-in">
          <keep-alive>
            <router-view></router-view>
          </keep-alive>
        </transition>
      </section>
    </el-col>
  </el-row>
</template>

<script>
  import axios from 'axios';

  var qs = require('qs');

  export default {
    data() {
      return {
        isMiniMenu: false,
        menu: [],
        userName: 'srw962'
      }
    },
    beforeCreate() {
      // beforeCreate 事件时仅仅创建了vue对象，里面数据并未设置
      // 所以this.userName没有值
      console.log("beforeCreate: ", this.userName);

      // 默认axios使用json传给后台
      // 如果要传application/x-www-form-urlencoded 到后台，使用qs.stringify(object)
      axios.post('/rest/user/getMenu', qs.stringify({
        userName: 'srw962' // this.userName
      })).then(response => {
        this.menu = response.data;
      }).catch(error => {
        //self.message = 'Error: ' + error.response.status;
      });
    },
    mounted() {
    },
    computed: {},
    methods: {
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
      handleselect: function (a, b, c) {
      },
      logout() {
      }
    }
  }
</script>
