import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/car';
import { CarService } from '../../services/car.service';
@Component({
  selector: 'app-car-add',
  templateUrl: './car-add.component.html',
  styleUrls: ['./car-add.component.css']
})
export class CarAddComponent implements OnInit {

  car: Car;

  constructor(private carService: CarService) {
    this.car = new Car();
  }

  ngOnInit() {
  }

  send() {
    this.carService.create(this.car).subscribe(res => alert('Dodano pojazd'));
  }
}
