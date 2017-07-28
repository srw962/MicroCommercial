<template>
  <div class="chat">
    <h2>Realtime chat</h2>
    <h4>(open it in another browser window)</h4>

    <table style="width: 100%">
      <tr v-for="m in messages">
        <td class="label label-pill label-default" width="20%">{{ m.author }}</td>
        <td class="label label-success" width="80%">{{ m.message }}</td>
      </tr>
    </table>

    <el-form labelPosition="right" label-width="80px">
      <el-form-item label="Author:">
        <el-input v-model="author"></el-input>
      </el-form-item>
      <el-form-item label="Message:">
        <el-input v-model="message"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" :disabled="!message || !author" @click="postMessage">Post</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import jQuery from "jquery"

  var $ = window.$ = window.jQuery = jQuery

  export default {
    name: 'chat',
    data() {
      return {
        author: 'John',
        message: 'Vue.js works great with Java',
        messages: []
      };
    },
    components: {},
    created: function () {
      console.log('created');
      var eventSource = new EventSource('/rest/chat/sse/updates');
      var self = this;
//      eventSource.onmessage = function (e) {
//        var msg = JSON.parse(e.data);
//        console.log(e);
//        self.messages.push(msg);
//      };

      eventSource.addEventListener("message", function(e){
        console.log("message");
        var msg = JSON.parse(e.data);
        console.log(e);
        self.messages.push(msg);
      },false);
    },
    methods: {
      postMessage: function () {
        var self = this;

        $.ajax({
          url: "/rest/chat/post",
          type: "post",
          dataType: "json",
          data: JSON.stringify({
            author: self.author,
            message: self.message
          }),
          contentType: "application/json",
          success: function (data) {

          }
        }).then(function () {
          self.message = 'Send next message';
        });
      }
    }
  };
</script>
