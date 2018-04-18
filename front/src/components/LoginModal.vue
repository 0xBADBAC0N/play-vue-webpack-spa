<template>
    <div style="display: inline;">
        <b-btn v-b-modal.modalPrevent>Login</b-btn>
        <b-modal id="modalPrevent"
                 ref="modal"
                 title="Submit your name"
                 @ok="handleOk"
                 @shown="clearFields">
            <form @submit.stop.prevent="handleSubmit">
                <b-form-input type="text" placeholder="Enter your email" v-model="email"></b-form-input>
                <b-form-input type="password" placeholder="Enter your pw" v-model="password"></b-form-input>
            </form>
        </b-modal>
    </div>
</template>

<!--suppress JSAnnotator -->
<script>
    import API from '../api/node'

    export default {
        data() {
            return {
                email: null,
                password: null
            }
        },
        methods: {
            clearFields() {
                this.email = '',
                this.password = ''
            },
            handleOk(evt) {
                // Prevent modal from closing
                evt.preventDefault()
                if (!this.email) {
                    alert('Please enter your email.')
                } else if (!this.password) {
                    alert('Please enter your password.')
                } else {
                    this.handleSubmit()
                }
            },
            handleSubmit() {
                API.getSession(this.email, this.password,result => {
                    if (result){
                        alert('yay:'+result)
                    }
                })

                this.clearFields()
                this.$refs.modal.hide()
            }
        }
    }
</script>