<template>
  <div class="hello" style="width: 400px;">
    <h1>{{ msg }}</h1>

    <p>Counter: {{count}}</p>
    <el-progress :percentage="count">
      {{count}}%
    </el-progress>
    <el-button @click="inc">+1</el-button>
    <el-button @click="dec">-1</el-button>
    <el-button @click="setProgress(42)">42</el-button>
  </div>
</template>

<script>
  import store from '../stores/store';

  export default {
    name: 'counter',
    data() {
      return {
        // note: changing this line won't causes changes
        // with hot-reload because the reloaded component
        // preserves its current state and we are modifying
        // its initial state.
        msg: 'Hello Vue.js!!!'
      };
    },
    computed: {
      count() {
        return store.state.count;
      }
    },
    methods: {
      inc: function () {
        store.commit('INCREMENT');
      },
      dec: function () {
        store.commit('DECREMENT');
      },
      setProgress: function (number) {
        store.commit('SET_PROGRESS', number);
      }
    }
  };
</script>
