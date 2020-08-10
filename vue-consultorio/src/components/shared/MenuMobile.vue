<template>
    <div>
        
        <v-navigation-drawer app absolute temporary class="blue-grey lighten-2" v-model="showNav">

        <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="title">
           <h4> Bem vindo</h4>
          </v-list-item-title>
          <v-list-item-subtitle>
            <h5>{{pegarApelido}}</h5>
          </v-list-item-subtitle>
           <v-divider></v-divider>
                <v-list dense nav>
                    <v-list-item-content><router-link to='/login'>Login</router-link> </v-list-item-content>
                    <v-list-item-content><router-link to='/inicial'> Nos conheça</router-link></v-list-item-content>
                    <v-list-item-content><router-link to='/pacientes' > Pacientes</router-link></v-list-item-content>
                    <v-list-item-content><router-link to='/doutores'> Doutores</router-link></v-list-item-content>
                    <v-divider></v-divider>
                    <v-list-item-content><button class="btn waves-effect waves-light red accent-4" @click.prevent='logout()'> Logout</button></v-list-item-content>
                </v-list>
        </v-list-item-content>
        </v-list-item>

        </v-navigation-drawer>
        
        
   <div class="col s12 red accent-1" v-if="!showNav" >
        <i @click.prevent="navController" data-activates class="material-icons medium">format_align_justify</i>

   </div>
    </div>
</template>

<script> 

export default {
    data(){
        return{
            showNav: false
        }
    },
    mounted(){

    },
    computed:{
        usuarioLogado(){
            return Boolean(this.$store.state.token)
        },
        pegarApelido(){
            return String(this.$store.state.apelido)
        }
    },

    methods:{
        logout(){
            this.$store.commit('DESLOGAR_USER')
            
            this.$router.push({name:'login'})
        },
        navController(){
            this.showNav = !this.showNav
            console.log(this.showNav);
        }
    }
}
</script>