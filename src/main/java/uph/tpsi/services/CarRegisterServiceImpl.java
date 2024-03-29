package uph.tpsi.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uph.tpsi.models.Car;
import uph.tpsi.models.CarRegister;
import uph.tpsi.repositories.CarRegisterRepository;
import uph.tpsi.repositories.CarRepository;

import java.time.Instant;
import java.util.List;

@Service
public class CarRegisterServiceImpl implements CarRegisterService
{
        private final CarRepository carRepository;

        private final CarRegisterRepository carRegisterRepository;

        @Autowired
        public CarRegisterServiceImpl ( CarRepository carRepository, CarRegisterRepository carRegisterRepository )
        {
                this.carRepository = carRepository;
                this.carRegisterRepository = carRegisterRepository;
        }

        @Override //id pojazdu
        public CarRegister create ( Long id )
        {
                Car car = carRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Not found" ) );

                CarRegister carRegister = new CarRegister();
                carRegister.setCar( car );
                carRegister.setPaid( false );
                carRegister.setRegisterDate( Instant.now() );
                carRegister.setRegisterNumber( "WSI " + RandomStringUtils.randomAlphanumeric( 5 ).toUpperCase() );
                return carRegisterRepository.save( carRegister );
        }

        @Override
        public CarRegister pay ( Long id )
        {
                CarRegister carRegister = carRegisterRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Not found" ) );
                carRegister.setPaid( !carRegister.isPaid() );
                return carRegisterRepository.save( carRegister );
        }

        @Override
        public List<CarRegister> findAll ()
        {
                return carRegisterRepository.findAll();
        }


}
