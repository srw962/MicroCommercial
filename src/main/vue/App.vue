<template>
    <div id="app">
        <div>
            <div style="float:left;">
                <img src="./assets/logo.png" style="width:32px;height:32px;">
            </div>

            <div style="left:32px;float:left;">
                <el-menu theme="dark"
                         :default-active="activeIndex"
                         class="el-menu-demo"
                         mode="horizontal"
                         router="true"
                         @select="handleSelect">
                    <el-menu-item index="1" route="/">Home</el-menu-item>
                    <el-menu-item index="2" route="/counter">Counter</el-menu-item>
                    <el-menu-item index="3" route="/chat">Chat</el-menu-item>
                    <el-menu-item index="4"><a href="http://element.eleme.io" target="_blank">element-ui</a>
                    </el-menu-item>
                </el-menu>
            </div>

            <div style="clear:both;line-height:0;height:0;font-size:0;overflow:hidden;"></div>
        </div>

        <transition mode="out-in">
            <keep-alive>
                <router-view></router-view>
            </keep-alive>
        </transition>
    </div>
</template>

<script>
    export default {
        name: 'app',
        data() {
            return {activeIndex: 1};
        }
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }
</style>
