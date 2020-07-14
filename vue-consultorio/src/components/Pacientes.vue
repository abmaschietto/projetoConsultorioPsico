<template>
  <div>

    <img class="responsive-img" src="../assets/paciente.jpg">

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
<br><br>
    <h3 class="centralizado">{{estado }}</h3>
    <div class="row" id="cadastro">

        
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
        <a @click="limparDados" class="btn-floating btn-large pulse waves-effect waves-light red"><i class="material-icons">add</i></a>
        
      </form>
    </div>
    <rodape />
  </div>
</template>

<script>
import PService from '../services/pacientesService';
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
      erros:[],
      estado:'Cadastro de pacientes'

    }
  },
  methods:{
    listar(){
      PService.listar()
      .then(res => {
        this.pacientes = res.data
      })    
    },
    listaDoc(){
      PService.listarDoutores()
      .then(res =>{
        this.doutores = res.data
      })
    },
    gravar(){
      if(this.paciente.id){
        PService.atualizarPaciente(this.paciente)
        .then(() =>{
          this.listar()
          this.paciente = {}
        }).catch(error =>{
          this.erros = error.response.data
        })    
      }else{
      PService.gravarPaciente(this.paciente)
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
      this.doutor = paciente.doutor.id
      this.paciente.id = paciente.id
      
    },
    limparDados(){
      this.paciente = {}
      this.estado = "Novo Cadastro"  
    },
    deletar(paciente){ 
      PService.deletarPaciente(paciente)
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