import axios from 'axios'

export default {
  getHelloWorld (cb) {
    axios.get('/helloworld/')
    .then(response => {
      cb(response.data)
    })
  }
}

