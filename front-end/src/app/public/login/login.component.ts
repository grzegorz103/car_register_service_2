import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from 'selenium-webdriver/http';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: any = {};
  loginIncorrect: boolean;
  
  constructor(
    private router: Router,
    private userService: UserService
  ) {
    localStorage.clear();
    sessionStorage.clear();
  }

  ngOnInit() {
    sessionStorage.setItem('token', '');
  }

  login() {
    this.userService.isLoginCorrect(this.model.username, this.model.password).subscribe(isValid => {
      if (isValid) {
        sessionStorage.setItem(
          'token',
          btoa(this.model.username + ':' + this.model.password)
        );
       localStorage.setItem('username', this.model.username);
        alert('Zalogowano!');
        this.router.navigate(['/']);
      } else {
        alert('Hasło/login niepoprawne');
      }
    });
  }
}
