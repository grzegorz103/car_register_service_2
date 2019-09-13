package uph.tpsi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uph.tpsi.models.Car;
import uph.tpsi.services.CarService;

import java.util.List;

@RestController
@RequestMapping ("/api/car")
public class CarController
{
        private final CarService carService;

        @Autowired
        public CarController ( CarService carService )
        {
                this.carService = carService;
        }

        @GetMapping
        public List<Car> findCarsByUser ()
        {
                return carService.findByUser();
        }

        @PostMapping
        public Car create ( @RequestBody Car car )
        {
                return carService.create( car );
        }

        @GetMapping ("/one/{id}")
        public Car findById ( @PathVariable ("id") Long id )
        {
                return carService.findById( id );
        }

        @GetMapping ("/bynumber/{number}")
        public Car findByRegisterNumber ( @PathVariable ("number") String number )
        {
                return carService.findByRegisterNumber( number );
        }

}
