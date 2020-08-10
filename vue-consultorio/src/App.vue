<template>
  <div id="app"> 
    <div v-if="isMobile()">
      <menuMobile />
    </div>
    <div v-else>
      <navegador  />
    </div>
    <router-view/>
    <rodape id="foot" />
  </div>
</template>

<script>
import { DetectMobile } from '@/Mixins/DetectMobile'
export default {
  name: 'App',
  mixins: [DetectMobile],

  mounted(){
   this.isMobile()
  
  },
  data(){
    return{
      con: false
    }
  }
  
}
</script>

<style  scoped>

  .foot {
    display: flex;
    min-height: 100vh;
    flex-direction: column;
  }

  .foot {
    flex: 1 0 auto;
  }
</style>>

