<template>
    <div class="botoes">
        <button @click="atualizar" class="waves-effect btn teal darken-2 offset-s6"><i class="material-icons">edit</i></button>
        <button @click='deletar' class="waves-effect btn red darken-1 col s6 offset-s6"><i class="material-icons">delete_sweep</i></button>
    </div>
</template>

<script>
export default {
    methods:{
        atualizar(){
            this.$emit('atualizar')
        },
        deletar(){
            this.$emit('deletar')
        }
    }
}
</script>

<style scoped>

.botoes{
    padding-left: 15px;
}

</style>>

