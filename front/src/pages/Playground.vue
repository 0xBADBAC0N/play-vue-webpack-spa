<template>
  <div>
      <p>RestAPI test</p>
      <button id="myBtn" type="button" class="btn btn-primary" @click="consoleClick" ref="myBtn">Request</button>
      <p>{{lol}}</p>


  </div>
</template>

<script>
import API from '../api/node'
import Fingerprint2 from 'fingerprintjs2';

export default {
  name: 'Playground',
  data () {
    return {
      lol: null
    }
  },
  methods: {
    consoleClick() {
      API.getHelloWorld(result => {
        this.lol = result
        // new Fingerprint2().get((fingerprint, components) => {
        //     alert(fingerprint+"\n"+components)
        //      console.log(JSON.stringify(components))
        // })
      })
    }
  },
    components: {
    }
}

</script>
