// import { Component, OnInit, Input } from '@angular/core';
// import { UserService } from '../user.service';
// import { Router } from '@angular/router';

// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.scss']
// })
// export class LoginComponent implements OnInit {
//   @Input() userDetails = { username: '', password: '' }

//   invalidLogin = false
//   constructor(public userservice:UserService, public router: Router) { }

//   ngOnInit(): void {
//   }


//   checkLogin(userDetails) {
//   //   this.userservice.authenticate(userDetails)
//   //   .subscribe(result =>{
//   //   if (true)
//   //    {
//   //     this.router.navigate([''])
//   //     this.invalidLogin = false
//   //   } else
//   //     this.invalidLogin = true
//   // });

//   this.userservice.authenticate(userDetails)
//   .subscribe((result:any) => {
//       if (result != null ) {
//           // login successful
//           this.router.navigate([''])
//           this.invalidLogin = false
//       } else {
//           // login failed
//           this.invalidLogin = true
//       }
//   }, error => {
//     this.invalidLogin = true
//   });
//   }
  
//   // checkLogin(userDetails) {
//   //   if (this.userservice.authenticate(userDetails)
//   //   ) {
//   //     this.router.navigate([''])
//   //     this.invalidLogin = false
//   //   } else
//   //     this.invalidLogin = true
//   // }

// }

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { UserService } from '../user.service';

import { AuthenticationService } from '../authentication.service';

@Component({ templateUrl: 'login.component.html' })
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    error = '';

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService
    ) { 
        // redirect to home if already logged in
        if (this.authenticationService.currentUserValue) { 
            this.router.navigate(['/dashboard']);
        }
    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.authenticationService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe(
                data => {
                   // this.router.navigate([this.returnUrl]);
                    this.router.navigate(['/dashboard'])
                },
                error => {
                    this.error = error;
                    this.loading = false;
                });
    }
}

