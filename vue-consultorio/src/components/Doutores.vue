<template>
    <div>
        <img class="responsive-img" src="../assets/psico.jpg">
        <h2 class="centralizado">Doutores</h2>

         <div class="container">
    <table class="striped centered">
      <thead>
        <tr>
          <th>Nome</th>
          <th>CRP</th>
          <th>Especialidade</th>
          <th>Disponibilidade</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="doutor in doutores" :key="doutor.id">
          <td>{{ doutor.nome }}</td>
          <td>{{ doutor.crp }}</td>
          <td>{{ doutor.especialidade }}</td>
          <td>Disponível</td>
          <botao @atualizar='att(doutor)' @deletar='deleta(doutor)'/>
        </tr>
      </tbody>
    </table>   
  </div>

    <h3 class="centralizado">Quer fazer parte de nossa equipe?</h3>
    <br><br>

    <div class="centralizado">
    <blockquote class="centralizado">
 
      "Os melhores psicólogos do mundo, eu garanto."
      <br>
     <p class="texto">-- Jason Vohres</p>

    </blockquote>
<br>
    <blockquote class=".center-align">
 
      "REEEEEEEEEEEEEEEEEEEEEEEEEEEE."
      <br>
     <p class="texto">-- Pepe</p>

    </blockquote>
</div>
    <div class="row">
        <form class="col s12" @submit.prevent="gravar()">
        <div class="row">
            <div class="input-field col s6">
            <input id="first_name" type="text" class="validate" v-model="doutor.nome">
            <label for="first_name">Nome Completo</label>
            </div>
            <div class="input-field col s6">
            <input id="crp" type="number" class="validate" v-model="doutor.crp">
            <label for="crp">CRP</label>
            </div>
        </div>
            <div class="input-field col s6">
            <input id="especialidade" type="text" class="validate" v-model="doutor.especialidade">
            <label for="especialidade">Especialidade</label>
            </div>
        <div class="row">
            <div class="input-field col s6">
            <input disabled id="disabled" type="text" class="validate">
            <label for="disabled">Disponível</label>
            </div>
        </div>
         <button class="btn-floating waves-effect waves-light red btn-large pulse"><i class="material-icons">save</i></button> 
        <a @click='limpaDados' class="btn-floating btn-large pulse waves-effect waves-light red"><i class="material-icons">add</i></a>
        </form>
   </div>
    <rodape />
</div>   
</template>

<script>
import Botoes from './shared/Botoes';

export default {
    mounted(){
        this.listar()
    },
    data(){
        return{
            doutores:[],
            doutor:{
                nome:'',
                crp:'',
                especialidade: ''
            },
            erros:[]
        }
    },
    components:{
        botao:Botoes
    },

    methods:{
        listar(){
            this.$http.get('api/doutores')
            .then((res) =>{
                this.doutores = res.data
            })
        },
        gravar(){
            if(!this.doutor.id){
                this.$http.post('api/doutores', this.doutor)
                .then(()=>{
                    this.doutor = {}
                    this.listar()
                }).catch(err =>{
                    this.erros = err.response.data
                })
            }else{
                this.$http.put('api/doutores/' + this.doutor.id, this.doutor)
                .then(()=>{
                    this.doutor = {}
                    this.listar()
                }).catch(err =>{
                    this.erros = err.response.data
                })
                
            }
        },
        att(doutor){
            this.doutor = doutor
            console.log(this.doutor);     
        },
        limpaDados(){
            this.doutor = {}
        },
        deleta(doutor){
            this.$http.delete('api/doutores/' + doutor.id, doutor)
            .then(( ) =>{
                this.listar()
            }).catch(err =>{
                this.erros = err.response.data
            })
        }
    }
}
</script>

<style  scoped>
.centralizado{
    text-align: center;
}
.texto{
    font-style: oblique;
}

</style>>
