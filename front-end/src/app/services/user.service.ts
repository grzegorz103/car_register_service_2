import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = 'http://localhost:8080/api/users/';

  constructor(private http: HttpClient) {
  }


  getUsername() {
    return localStorage.getItem('username');
  }

  isLoginCorrect(username: string, password: string) {
    return this.http.post<Observable<boolean>>(this.url + 'login?username=' + username + '&password=' + password, null
    );
  }
  
  create(user: User) {
    return this.http.post<User>(this.url, user);
  }

  getToken(): string {
    return sessionStorage.getItem('token');
  }

  isAuthenticated() {
    return this.getToken() !== null && this.getToken() !== '';
  }

}
