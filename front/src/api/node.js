import axios from 'axios'

export default {
  getHelloWorld (cb) {
    axios.get('/helloworld/')
    .then(response => {
      cb(response.data)
    })
  },

    getSession (email, password, cb) {
        axios.post('/login/', {
            email: email,
            password: password
        })
        .then(response => {
         cb(response.data)
    })
    }
}

