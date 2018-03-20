<template>
    <div class="container">
        <router-link to="/">Home</router-link>
        <router-link to="/about">About</router-link>
        <router-link to="/yolo">Yolo</router-link>
        <router-link to="/asd">asd</router-link>
        <router-view/>
    </div>
</template>

<style scoped>
    .container {
        max-width: 600px;
        margin: 0 auto;
        padding: 15px 30px;
        background: #f9f7f5;
    }
</style>
