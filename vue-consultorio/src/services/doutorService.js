import { http } from './config';

export default{
    listar:()=>{
        return http.get('doutores')
    },
    cadastrar:(doutor)=>{
        return http.post('doutores', doutor)
    },
    atualizar:(doutor)=>{
        return http.put('doutores/'+doutor.id, doutor)
    },
    deleta:(doutor)=>{
        return http.delete('doutores/'+doutor.id, doutor)
    }
}