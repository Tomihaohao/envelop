<template>
  <div id="app">
      <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app',
  components: {

  }
}
</script>

<style>
    html{
        height: 100%;
    }
    body{
      padding:0px;
      margin:0px;
      height: 100%;
      display: block;
    }
    #app {
      font-family: 'Avenir', Helvetica, Arial, sans-serif;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;
      text-align: center;
      color: #2c3e50;
      background:#dcdcdc;
      background-image: url("./assets/background/1.jpg");
      background-size: cover;
      background-position: center;
      height: 100%;
    }
</style>
