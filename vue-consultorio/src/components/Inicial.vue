<template>
    <div>
         <img class="responsive-img" src="../assets/consultorio2.jpg">
        <h2 class="centralizado">Nossa missão</h2>
        <juramento />
        <larissa />

    </div>
</template>

<script>
import Juramento from './shared/juramento'
import Larissa from './shared/cardLarissa'
export default {
    components:{
        juramento: Juramento,
        larissa: Larissa

    }
    
}
</script>

<style scoped>
.centralizado{
    text-align: center;
}

</style>