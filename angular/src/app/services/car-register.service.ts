import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CarRegister } from '../models/carRegister';
@Injectable({
  providedIn: 'root'
})
export class CarRegisterService {

  url = 'http://localhost:8080/api/carregisters/';

  constructor(private http:HttpClient) { }

  findAll(){
    return this.http.get<CarRegister[]>(this.url);
  }

  pay(id: number){
    return this.http.get<CarRegister>(this.url + 'pay/' + id);
  }

  create(id: number){
    return this.http.get<CarRegister>(this.url + 'create/' + id);
  }
}
