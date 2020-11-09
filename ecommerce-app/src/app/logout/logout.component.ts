import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent implements OnInit {

  constructor(public userservice:UserService, public router: Router) { }

  ngOnInit(): void {
    this.userservice.logOut();
    this.router.navigate(['login']);
  }

}
