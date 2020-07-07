import Pacientes from './components/Pacientes';
import Doutores from './components/Doutores';
import Home from './components/Home';

export const routes = [
    {path:'*', component: Home},
    {path:'/pacientes', component: Pacientes},
    {path:'/doutores', component: Doutores}
]


