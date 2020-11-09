import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';  
import {DataTablesModule} from 'angular-datatables';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';  
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { LoginComponent } from './login/login.component';
import { BasicAuthHtppInterceptorServiceService } from './basic-auth-htpp-interceptor-service.service';
import { ErrorInterceptor } from './error.interceptor';
import { fakeBackendProvider, JwtInterceptor } from './_helpers';



@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    RegisterComponent,
    HeaderComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
   ReactiveFormsModule,  
    HttpClientModule,  
    FormsModule,
    DataTablesModule 
  ],
  providers: [
   // {provide:HTTP_INTERCEPTORS, useClass:BasicAuthHtppInterceptorServiceService, multi:true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
    // provider used to create fake backend
    //fakeBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
