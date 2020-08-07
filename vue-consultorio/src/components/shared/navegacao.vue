<template>
    <div>
        <nav>
            <div class="nav-wrapper">
                <router-link to="/pepe" v-if="usuarioLogado"><a href="" class="brand-logo center">Bem vindo  -   {{pegarApelido}}</a></router-link>
                <router-link to="/pepe" v-else><a href="" class="brand-logo center">CLÍNICA LARISSA   </a></router-link>
                <ul class="right hide-on-med-and-down">
                <li><button @click.prevent='logout()'> Logout</button></li>
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
        this.teste()
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
        teste(){
            { console.log(this.$store.state);}
            
        }
    }
}
</script>