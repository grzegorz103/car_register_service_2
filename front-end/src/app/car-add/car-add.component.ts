import { Component, OnInit } from '@angular/core';
import { Car } from '../models/car';
import { CarService } from '../services/car.service';
import { CarType } from '../models/carType';

@Component({
  selector: 'app-car-add',
  templateUrl: './car-add.component.html',
  styleUrls: ['./car-add.component.css']
})
export class CarAddComponent implements OnInit {

  car: Car;
  carTypes: CarType[];

  constructor(private carService: CarService) {
    this.car = new Car();
    this.car.carType = new CarType();
    this.carService.findCartTypes().subscribe(res => this.carTypes = res);
  }

  ngOnInit() {
  }

  send() {
    this.carService.create(this.car).subscribe(res => alert('Zarejestrowano pojazd'));
  }
}
