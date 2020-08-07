<template>
<div class="center-align">

<div id="login-page" class="row">
    <div class="col s12 z-depth-6 card-panel">
      <form class="login-form" @submit.prevent="logar()">
        <div class="row">
        </div>
        <div class="row">
          <div class="input-field col s12">
            <i class="material-icons prefix">mail_outline</i>
            <input class="validate" id="email" type="email" v-model="usuario.email">
            <label for="email" data-error="wrong" data-success="right">Email</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <i class="material-icons prefix">lock_outline</i>
            <input id="password" type="password" v-model="usuario.senha">
            <label for="password">Password</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
              <button class="btn red accent-1  col s12">Login</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

</template>

<script>
export default {
    data(){
        return{
            usuario:{
                email:'',
                senha:''
            }
        }
    },

    methods:{
        logar(){
                this.$store.dispatch('logar', this.usuario)
                .then(()=>{
                  this.$router.push({name:'doutores'})
                }).catch(err =>{
                  console.log(err)
                })
            }
        }
}
</script>



<style scoped>

</style>