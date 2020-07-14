<template>
    <div>
        <nav>
            <div class="nav-wrapper">
                <router-link to="/pepe"><a href="" class="brand-logo center">CLÍNICA LARISSA</a></router-link>
                <ul class="left hide-on-med-and-down">
                    <li><router-link to='/pacientes'> Pacientes</router-link></li>
                    <li><router-link to='/doutores'> Doutores</router-link></li>
                    <li class="active"><router-link to='/home'> Nos conheça</router-link></li>
                </ul>
            </div>
        </nav>
    </div>
</template>

<script>
export default {

    
}
</script>