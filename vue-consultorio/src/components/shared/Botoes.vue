<template>
    <div class="botoes">
        <button @click="atualizar" class="waves-effect btn red lighten-1 "><i class="material-icons">edit</i></button>
        <button @click='deletar' class="waves-effect btn red lighten-1"><i class="material-icons">delete_sweep</i></button>
    </div>
</template>

<script>
export default {
    methods:{
        atualizar(){
            this.$emit('atualizar')
        },
        deletar(){
            if(confirm('Deseja deletar??')){
                 this.$emit('deletar')
            }
           
        }
    }
}
</script>

<style scoped>

.botoes{
    padding-left: 15px;
}

</style>>

