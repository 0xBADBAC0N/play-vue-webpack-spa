<template>
    <div class="container">
        <b-container class="bv-example-row">
            <b-nav pills>
                <b-nav-item :active-class="null" v-for="route in routes" :key="route.path" v-if="route.visible" :to="route.path">{{route.name}}</b-nav-item>
                <b-nav-item :to="failingRoute">Buggy</b-nav-item>
                <login-modal></login-modal>
            </b-nav>
            <router-view/>
        </b-container>
    </div>
</template>

<style scoped>
    .container {
        display: flex;
        flex-direction: column;

        max-width: max-content;
        margin: 0 auto;
        padding: 15px 30px;
        background: #f9f7f5;
    }
</style>

<script>
    import LoginModal from "../components/LoginModal.vue"
    import routes from '../router/routes'

    export default {
        components: {
          LoginModal
        },
        data() {
            return {
                routes,
                failingRoute: "/broken"
            }
        },
        methods: {
        }
    }
</script>
