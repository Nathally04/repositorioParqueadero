import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PaginaPrincipalComponent } from './components/paginaPrincipal.component';
import { IngresarComponent } from './components/ingresar.component';
import { ConsultarComponent } from './components/consultar.component';
import { SalirComponent } from './components/salir.component';

const appRoutes: Routes = [
    { path: '', component: PaginaPrincipalComponent },
    { path: 'paginaPrincipal', component: PaginaPrincipalComponent },
    { path: 'ingresos', component: IngresarComponent },
    { path: 'consultas', component: ConsultarComponent },
    { path: 'salidas', component: SalirComponent },
    { path: '**', component: PaginaPrincipalComponent }
];

export const appRoutingProviders: any [] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);