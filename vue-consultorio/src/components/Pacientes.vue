<template>
  <div>
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
          <td>{{ paciente.doutor.nome}}</td>
        
        <botao @atualizar='atualiza(paciente)'/>
        </tr>


      </tbody>
    </table>
<br><br>
    <h3 class="centralizado">Cadastro de pacientes</h3>
    <div class="row" id="cadastro">


      <form class="col s12" @submit.prevent="gravar">
        <div class="row">
          <div class="input-field col s12">
            <input placeholder="Nome" id="first_name" type="text" class="validate" v-model="paciente.nome" />
            <label for="first_name" class="campoAdd">Nome</label>
        </div> 
          <div class="input-field col s12">
            <input placeholder="Problema" id="problema" type="text" class="validate" v-model='paciente.motivo' />
            <label for="problema">Nos conte seu problema</label>
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

        <button class="waves-effect waves-light  red lighten-1 btn-large"><i class="material-icons">save</i></button>
        
      </form>
    </div>
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
      erros:[]

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
      console.log(this.paciente);
      
      this.paciente.nome = paciente.nome,
      this.paciente.motivo = paciente.motivoConsulta,
      this.doutor = paciente.doutor.id
      this.paciente.id = paciente.id
      
    }
  }
};
</script>

<style  scoped>



.centralizado{
  text-align: center;
}
</style>