<template>
    <div style="display: inline;">
        <b-btn v-b-modal.modalPrevent>Login</b-btn>
        <!-- Main UI -->
        <!--<div class="mt-3 mb-3">-->
        <!--Submitted Names:-->
        <!--<ul>-->
        <!--<li v-for="n in names">{{n}}</li>-->
        <!--</ul>-->
        <!--</div>-->
        <!-- Modal Component -->
        <b-modal id="modalPrevent"
                 ref="modal"
                 title="Submit your name"
                 @ok="handleOk"
                 @shown="clearName">
            <form @submit.stop.prevent="handleSubmit">
                <b-form-input type="text" placeholder="Enter your name" v-model="name"></b-form-input>
                <b-form-input type="text" placeholder="Enter your pw" v-model="password"></b-form-input>
            </form>
        </b-modal>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                name: null,
                names: [],
                password: null
            }
        },
        methods: {
            clearName() {
                this.name = ''
            },
            handleOk(evt) {
                // Prevent modal from closing
                evt.preventDefault()
                if (!this.name) {
                    alert('Please enter your name')
                } else {
                    this.handleSubmit()
                }
            },
            handleSubmit() {
                this.names.push(this.name)
                this.clearName()
                this.$refs.modal.hide()
            }
        }
    }
</script>