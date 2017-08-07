import Vue from 'vue'
import Router from 'vue-router'
import Hello from './../components/hello'
import Chat from './../components/chat'
import Counter from './../components/counter'
import AjaxTest from './../components/ajaxTest'
import Foo from './../components/foo'

Vue.use(Router)

export default new Router({
  routes: [{
    path: '/',
    name: 'Hello',
    component: Hello
  }, {
    path: '/chat',
    name: 'Chat',
    component: Chat
  }, {
    path: '/counter',
    name: 'Counter',
    component: Counter
  }, {
    path: '/ajaxTest',
    name: 'AjaxTest',
    component: AjaxTest
  }, {
    path: '/foo/:src',
    name: 'foo',
    component: Foo
  }]
})
