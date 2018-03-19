<template>
  <main-layout>

    <p>Welcome home</p>

    <div id="hello">
      <div id="images">
        <img src="/assets/images/scala.png" alt="Scala"> +
        <img src="/assets/images/play.png" alt="Play Framework"> +
        <img src="/assets/images/vue.png" alt="Vue.js">
      </div>
      <h1>Hello from <span class="text-primary">Vue.js</span>!</h1>
    </div>
  </main-layout>
</template>

<style scoped lang="scss">
  img {
    height: 100px;
  }
</style>

<script>
  import MainLayout from '../layouts/Main.vue'
  import Container from "bootstrap-vue/es/components/layout/container";

  export default {
    components: {
        Container,
        MainLayout
    }
  }
</script>
