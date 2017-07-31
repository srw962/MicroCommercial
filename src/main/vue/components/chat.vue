<template>
    <div class="chat" style="width:500px;">
        <h2>Realtime chat</h2>
        <h4>(open it in another browser window)</h4>

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

        <br/>

        <el-table :data="messages" border>
            <el-table-column
                prop="author"
                label="author"
                width="100">
            </el-table-column>
            <el-table-column
                prop="message"
                label="message"
                width="300">
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import axios from 'axios';

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

            eventSource.addEventListener("message", function (e) {
                var msg = JSON.parse(e.data);
                console.log(e);
                self.messages.push(msg);
            }, false);
        },
        methods: {
            postMessage: function () {
                var self = this;

                axios.post('/rest/chat/post', {
                    author: self.author,
                    message: self.message
                }).then(response => {
//          self.message = response.data.author;
                    self.message = 'Send next message';
                }).catch(error => {
                    self.message = 'Error: ' + error.response.status;
                });
            }
        }
    };
</script>
