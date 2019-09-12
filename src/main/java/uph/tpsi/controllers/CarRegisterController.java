package uph.tpsi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uph.tpsi.models.CarRegister;
import uph.tpsi.services.CarRegisterService;

import java.util.List;

@RestController
@RequestMapping ("/api/carregisters")
public class CarRegisterController
{
        private final CarRegisterService carRegisterService;

        @Autowired
        public CarRegisterController ( CarRegisterService carRegisterService )
        {
                this.carRegisterService = carRegisterService;
        }

        @GetMapping
        public List<CarRegister> findAll ()
        {
                return carRegisterService.findAll();
        }

        @GetMapping ("/pay/{id}")
        public CarRegister pay ( @PathVariable ("id") Long id )
        {
                return carRegisterService.pay( id );
        }

        @GetMapping ("/create/{id}")
        public CarRegister create ( @PathVariable ("id") Long id )
        {
                return carRegisterService.pay( id );
        }
}
