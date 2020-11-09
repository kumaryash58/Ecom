import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { DashboardComponent } from './dashboard/dashboard.component';


const routes: Routes = [
 { path : 'login', component: LoginComponent},
 { path : 'register', component: RegisterComponent},
 { path : 'forgot-password', component: ForgotPasswordComponent},
 { path : 'home', component: HomeComponent},
 { path: 'logout', component: LogoutComponent },
 { path : 'dashboard', component: DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [LoginComponent, ForgotPasswordComponent, RegisterComponent, HomeComponent]
