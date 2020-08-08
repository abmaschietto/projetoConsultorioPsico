<template>
  <div id="app"> 
    <navegador  />
    <router-view/>
    <rodape id="foot" />
  </div>
</template>

<script>

export default {
  name: 'App',
  components:{

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

