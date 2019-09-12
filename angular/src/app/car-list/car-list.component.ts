import { Component, OnInit } from '@angular/core';
import { CarService } from '../services/car.service';
import { Car } from '../models/car';
import { CarRegisterService } from '../services/car-register.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  cars: Car[];

  constructor(private carService: CarService,
    private carRegisterService: CarRegisterService) {
  }

  ngOnInit() {
    this.carService.findCarsByUser().subscribe(res => this.cars = res);
  }

  register(id: number) {
    this.carRegisterService.create(id).subscribe(res => this.ngOnInit());
  }

}
