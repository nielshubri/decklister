<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <HelloWorld msg="Welcome to Decklister"/>
  <createUser/>
  <getUsers/>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import createUser from "./components/createUser.vue";
import getUsers from './components/getUsers.vue';
export default {
  name: 'App',
  components: {
    HelloWorld,
    createUser,
    getUsers,
}
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
