import { Component, OnInit } from '@angular/core';
import { CarService } from '../services/car.service';
import { Car } from '../models/car';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  car: Car;

  constructor(private carService: CarService,
    private activatedRoute: ActivatedRoute) {
    this.carService.findOneById(this.activatedRoute.snapshot.params['id']).subscribe(res=>this.car = res);
  }

  ngOnInit() {
  }

}
