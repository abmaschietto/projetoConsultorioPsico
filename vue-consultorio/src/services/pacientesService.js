import { http } from './config';

export default {
    listar:()=>{
        return http.get('/pacientes')
    },
    listarDoutores:()=>{
        return http.get('/doutores')
    },
    gravarPaciente:(paciente)=>{
        return http.post('/pacientes', paciente)
    },
    atualizarPaciente:(paciente)=>{
        return http.put('/pacientes/'+ paciente.id, paciente)
    },
    deletarPaciente:(paciente)=>{
        return http.delete('/pacientes/'+paciente.id, paciente)
    }
}