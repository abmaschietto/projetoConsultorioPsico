<template>
  <div>

    <img class="responsive-img" src="../assets/paciente.jpg">
    <div class="container">
    <h2 class="centralizado">Lista de pacientes</h2>

    <table class="striped centered">
      <thead>
        <tr>
          <th>Nome</th>
          <th>Problema</th>
          <th>Doutor</th>
        </tr>
      </thead>

      <tbody v-for="paciente in pacientes" :key="paciente.id">
        <tr>
          <td>{{ paciente.nome }}</td>
          <td>{{ paciente.motivoConsulta }}</td>
          <td> <router-link to='/doutores'>{{ paciente.doutor.nome }} </router-link></td>
        
        <botao @atualizar='atualiza(paciente)' @deletar='deletar(paciente)'/>
        </tr>


      </tbody>
    </table>
    </div>
<br><br>
    <h3 class="centralizado">{{estado }}</h3>

     <p class="flow-text centralizado card-panel red lighten-1" v-if="erros">Ops, algum erro aconteceu no seu formulário de cadastro.
       Todos campos estão cadastrados?

     </p>
    <div class="row" id="cadastro">
      <div class="container">
      <form class="col s12" @submit.prevent="gravar">
        <div class="row">
          <div class="input-field col s12">
            <input  id="nome" type="text" class="validate" v-model="paciente.nome" />
            <label for="nome">Nome</label>
        </div> 
          <div class="input-field col s12">
            <input id="problema" type="text" class="validate" v-model='paciente.motivo' />
            <label for="problema">Motivo Consulta</label>
            <div>
              <div class="row">
                <div class="input-field col s8">
                  <input disabled value="Doutores disponíveis" id="doutores" type="text" class="validate" />
                </div>
              </div>
             <p>
                <label v-for="doutor in doutores" :key="doutor.id">
                  <input class="with-gap" name="group1" type="radio" :value='doutor.id' v-model="paciente.doutor" />
                  <span>{{doutor.nome}}</span>
                </label>
             </p>
            </div>
          </div>
        </div>

        <button class=" btn-floating waves-effect waves-light  red lighten-1 btn-large pulse "><i class="material-icons">save</i></button> 
        <a @click="limparDados" class="btn-floating btn-large pulse waves-effect waves-light red lighten-1"><i class="material-icons">person_add</i></a>
        
      </form>
      </div>
    </div>
  </div>
</template>

<script>
import Botoes from './shared/Botoes';

export default {
  mounted(){
    this.listar(),
    this.listaDoc()

  },

  components:{
    botao: Botoes
  },
  data(){
    return{
      pacientes:[],
      paciente:{
        nome:'',
        motivo:'',
        doutor:'',
        id:''
      },
      doutores: [],
      erros:'',
      estado:'Cadastro de pacientes'

    }
  },
  methods:{
    listar(){
      this.$http.get('api/pacientes')
      .then(res => {
        this.pacientes = res.data
      })    
    },
    listaDoc(){
      this.$http.get('api/doutores')
      .then(res =>{
        this.doutores = res.data
      })
    },
    gravar(){
      if(this.paciente.id){
        this.$http.put('api/pacientes/' + this.paciente.id, this.paciente)
        .then(() =>{
          this.listar()
          this.paciente = {}
        }).catch(error =>{
          this.erros = error.response.data

        })    
      }else{
      this.$http.post('api/pacientes', this.paciente)
      .then(()=>{
        this.listar()
        this.paciente = {}
      }).catch(err =>{
        this.erros = err.response.data
      })
      }
    },
    atualiza(paciente){
      this.estado =  "Atualizando paciente " + paciente.nome
      this.paciente.nome = paciente.nome,
      this.paciente.motivo = paciente.motivoConsulta,
      this.doutor = paciente.doutor
      this.paciente.id = paciente.id
      
    },
    limparDados(){
      this.paciente = {}
      this.estado = "Novo Cadastro"  
    },
    deletar(paciente){ 
      this.$http.delete('api/pacientes/' + paciente.id, paciente)
      .then(()=>{
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
</style>