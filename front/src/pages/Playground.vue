<template>
  <div>
      <p>RestAPI test</p>
      <button id="myBtn" type="button" class="btn btn-primary" @click="consoleClick" ref="myBtn">Request</button>
      <p>{{lol}}</p>


  </div>
</template>




<script>
import RAPI from '../api/node'

export default {
  name: 'Playground',
  data () {
    return {
      lol: null
    }
  },
  methods: {
    consoleClick() {
      RAPI.getHelloWorld(result => {
        this.lol = result
      })
    }
  },
    components: {
    }
}

</script>
