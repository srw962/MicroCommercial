<template>
  <div class="ajaxTest">
    <div>
      <span>jQuery ajax 调用</span>
      <button @click="testSimpleParam1">testSimpleParam</button>
      <button @click="testObjectParam1">testObjectParam</button>
      <button @click="testComplexObjectParam1">testComplexObjectParam</button>
    </div>

    <div>
      <span>axios ajax 调用</span>
      <button @click="testSimpleParam2">testSimpleParam</button>
      <button @click="testObjectParam2">testObjectParam</button>
      <button @click="testComplexObjectParam2">testComplexObjectParam</button>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  var qs = require('qs');
  import $ from 'jquery';

  export default {
    name: 'ajaxTest',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App'
      }
    },
    methods: {
      testSimpleParam1: function () {
        $.ajax({
          url: '/rest/ajax/testSimpleParam',
          data: {msg: 'Hello, World!', counter: '10'},
          success: function (data) {
            console.log(data.text);
            console.log(data.msg);
            console.log(data.counter);
          }
        });
      },

      testObjectParam1: function () {
        $.ajax({
          url: '/rest/ajax/testObjectParam',
          data: {message: 'Hello, World!', author: 'srw962'},
          success: function (data) {
            console.log(data.text);
            console.log(data.author);
            console.log(data.message);
          }
        });
      },

      testComplexObjectParam1: function () {
        $.ajax({
          url: '/rest/ajax/testComplexObjectParam',
          type: 'post',
          data: JSON.stringify({name: 'srw962', chatMessage: {message: 'Hello, World!', author: 'srw962'}}),
          dataType: "json",
          contentType: "application/json",
          success: function (data) {
            console.log(data.text);
            console.log(data.author);
            console.log(data.message);
          }
        });
      },

      testSimpleParam2: function () {
        axios.post('/rest/ajax/testSimpleParam', qs.stringify({
          msg: 'Hello, World!', counter: '10'
        })).then(function (response) {
          console.log(response.data.text);
          console.log(response.data.msg);
          console.log(response.data.counter);
        });
      },

      testObjectParam2: function () {
        axios.post('/rest/ajax/testObjectParam', qs.stringify({
          message: 'Hello, World!', author: 'srw962'
        })).then(function (response) {
          console.log(response.data.text);
          console.log(response.data.author);
          console.log(response.data.message);
        });
      },

      testComplexObjectParam2: function () {
        axios.post('/rest/ajax/testComplexObjectParam', {
          name: 'srw962', chatMessage: {message: 'Hello, World!', author: 'srw962'}
        }).then(function (response) {
          console.log(response.data.text);
          console.log(response.data.author);
          console.log(response.data.message);
        });
      }
    }
  }
</script>
