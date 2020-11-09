import { Component, OnInit, Input } from '@angular/core';
import { UserService } from '../user.service';  
import { from } from 'rxjs';
import {FormControl,FormGroup,Validators} from '@angular/forms';  
import { User } from '../user'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
 
  @Input() userDetails = { username: '', password: '' , vendorName: '', vendorBusiness: ''}

  constructor(public userservice:UserService, public router: Router) { }  
  
  user : User=new User();  
  submitted = false;  
  
  ngOnInit() {  
   // this.submitted=false;  
  }  
  addUser(userDetails) {
    this.userservice.createUser(this.userDetails).subscribe((data: {}) => {
      this.router.navigate(['/login'])
      
    })
  }
  // form=new FormGroup({  
  //   username:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),  
  //   password:new FormControl('',[Validators.required,Validators.email])   
  // });  
  
  // saveUser(saveform){  
  //   this.user=new User();     
  //   this.user.username=this.UserName.value;  
  //   this.user.password=this.Password.value;  
    
  //   this.submitted = true;  
  //   this.save();  
  // }  
  
    
  
  // save() {  
  //   this.userservice.createUser(this.user)  
  //     .subscribe(data => console.log(data), error => console.log(error));  
  //   this.user = new User();  
  // }  
  
  // get UserName(){  
  //   return this.form.get('username');  
  // }  
  
  // get Password(){  
  //   return this.form.get('password');  
  // }  
  

  
  // addUserForm(){  
  //   this.submitted=false;  
  //   this.form.reset();  
  // }  
}
