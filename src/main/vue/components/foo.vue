<template>
  <iframe :src="$route.params.src" style="border:none" width="100%" :height="iClientHeight"></iframe>
</template>

<script>
  export default {
    name: 'foo',
    data() {
      return {
        iClientHeight: 470
      };
    },
    created: function () {
      debugger;
      var body = document.getElementsByTagName("body")[0];
      //this.iClientHeight = body.clientHeight - 60 - 20;
    }
  };
</script>
