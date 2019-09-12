import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";

import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;

  constructor(
    private router: Router,
    private userService: UserService
  ) {
    this.user = new User();
  }

  ngOnInit() {
  }

  onSubmit() {
    this.userService.create(this.user)
      .subscribe(res => { alert('Dziękujemy za rejestrację'); this.router.navigate(['login']) },
        err => console.log('Error'));
  }
}
