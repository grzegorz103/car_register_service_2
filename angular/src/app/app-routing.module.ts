import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './shared/register/register.component';
import { LoginComponent } from './shared/login/login.component';
import { IndexComponent } from './shared/index/index.component';
import { CarListComponent } from './car/car-list/car-list.component';
import { CarAddComponent } from './car/car-add/car-add.component';
import { CarDetailsComponent } from './car/car-details/car-details.component';
import { CarRegisterListComponent } from './car-register-list/car-register-list.component';

const routes: Routes = [
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'cars/my', component: CarListComponent},
  { path: 'cars/add', component: CarAddComponent},
  { path: 'cars/:id/details', component: CarDetailsComponent},
  { path: 'registers', component: CarRegisterListComponent},
  { path: '', component: IndexComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
