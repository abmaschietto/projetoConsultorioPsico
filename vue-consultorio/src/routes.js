import Pacientes from './components/Pacientes';
import Doutores from './components/Doutores';
import Home from './components/Home';
import Pepe from './components/Pepe'

export const routes = [
    {path:'*', component: Home},
    {path:'/pacientes', component: Pacientes, name:'pacientes'},
    {path:'/doutores', component: Doutores, name:'doutores'},
    {path:'/pepe', component: Pepe, name:'pepe'}
]


