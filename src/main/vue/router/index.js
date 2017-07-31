import Vue from 'vue'
import Router from 'vue-router'
import Hello from './../components/hello'
import Chat from './../components/chat'
import Counter from './../components/counter'

Vue.use(Router)

export default new Router({
  mode: 'history',
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
  }]
})
