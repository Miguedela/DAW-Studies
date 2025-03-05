import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListadoClientesComponent } from './listado-clientes/listado-clientes.component';
import { ListadoProductosComponent } from './listado-productos/listado-productos.component';
import { Pagina404Component } from './pagina404/pagina404.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'listadoclientes', component: ListadoClientesComponent },
  { path: 'listadoproductos', component: ListadoProductosComponent },
  { path: '**', component: Pagina404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }