<template>
    <div>
        <nav>
            <div class="nav-wrapper">
                <h5 class="brand-logo center" v-if="usuarioLogado">Bem vindo  -   {{pegarApelido}}</h5>
                <h5 class="brand-logo center" v-else>CLÍNICA LARISSA   </h5>

   

                <!-- Menu Desktop-->
                <ul class="right hide-on-med-and-down">
                <li>
                    <button class="btn waves-effect waves-light red accent-4" @click.prevent='logout()'> Logout</button></li>
                </ul>
                <ul class="left hide-on-med-and-down">
                    <li><router-link to='/pacientes'> Pacientes</router-link></li>
                    <li><router-link to='/doutores'> Doutores</router-link></li>
                    <li><router-link to='/login'> Login</router-link></li>
                    <li class="active"><router-link to='/home'> Nos conheça</router-link></li>
                </ul>
            </div>
        </nav>
    </div>
</template>

<script> 

export default {
    data(){
        return{
            
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
        }
    }
}
</script>