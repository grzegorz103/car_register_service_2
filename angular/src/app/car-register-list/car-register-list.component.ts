import { Component, OnInit } from '@angular/core';
import { CarRegister } from '../models/carRegister';
import { CarRegisterService } from '../services/car-register.service';
import { CarService } from '../services/car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-car-register-list',
  templateUrl: './car-register-list.component.html',
  styleUrls: ['./car-register-list.component.css']
})
export class CarRegisterListComponent implements OnInit {

  carRegisters: CarRegister[];

  constructor(private carRegisterService: CarRegisterService,
    private carService: CarService,
    private router: Router) {

  }

  ngOnInit() {
    this.carRegisterService.findAll().subscribe(res => {
      this.carRegisters = res;
      this.carRegisters.sort((o1, o2) => o1.id - o2.id)
    });
  }

  pay(id: number) {
    this.carRegisterService.pay(id).subscribe(res => this.ngOnInit());
  }

  goToCarDetails(id: number){
    this.carService.findByRegisterNumberr(id).subscribe(res=>
      this.router.navigate(['/cars', res.id, 'details']));
  }
}
