import { Routes } from '@angular/router';
import { HomeAuthComponent } from './pages/auth/home-auth/home-auth.component';
import { LoginComponent } from './pages/auth/login/login.component';
import { RegisterComponent } from './pages/auth/register/register.component';

export const routes: Routes = [
  {
    path: '',
    component: HomeAuthComponent,
    children: [
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
      { path: '', redirectTo: 'login', pathMatch: 'full' } 
    ]
  },
  { path: '**', redirectTo: '' }
];