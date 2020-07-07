<template>
    <div>
        <nav>
            <div class="nav-wrapper">
                <a href="#!" class="brand-logo center">CLÍNICA LARISSA</a>
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