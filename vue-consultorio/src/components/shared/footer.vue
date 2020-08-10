<template>
    <div>
        <footer class="page-footer fixed">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Uma filiada Artucrop</h5>
                <p class="grey-text text-lighten-4">Saibe mais sobre outros afiliados de Artucrop</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><router-link to='/doutores' class="grey-text text-lighten-3">Seja um colaborador</router-link></li>
                  <li><router-link to="/pacientes" class="grey-text text-lighten-3">Nossos parceiros</router-link></li>
                  <li><router-link class="grey-text text-lighten-3" to="/pepe">Surpresa</router-link></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2020 Artucrop INC
            <a class="grey-text text-lighten-4 right" href="https://github.com/abmaschietto">GitHub</a>
            </div>
          </div>
        </footer>
    </div>
</template>

<script>
export default {
    
}
</script>

<style  scoped>



</style>