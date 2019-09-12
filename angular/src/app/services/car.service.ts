import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Car } from '../models/car';

@Injectable({
  providedIn: 'root'
})
export class CarService {
 
  url = 'http://localhost:8080/api/car/';

  constructor(private http: HttpClient) { }

  findCarsByUser() {
    return this.http.get<Car[]>(this.url);
  }

  create(car: Car) {
    return this.http.post<Car>(this.url, car);
  }

  findOneById(id: number) {
    return this.http.get<Car>(this.url + 'one/' + id);
  }
}
