<template>
<div>
    <p>BAM</p>
</div>

</template>


<script>
    import axios from 'axios'

    export default {
        loadConfig (cb, cbe, {nodeId}) {
            if (process.env.MOCK_APIS) {
                var config = { nodeId: nodeId, time: Date.now() }

                let random = Math.random()
                let probability = 0.5
                let success = random > probability
                let error = { reason: 'test error', random, probability, success }

                return setTimeout(() => success ? cb(config) : cbe(error), 400)
            }

            axios.get('/api/node/' + nodeId + '/configuration').then(response => {
                cb(response.data)
        }).catch(error => {
                cbe(error)
            })
        }
    }
</script>
