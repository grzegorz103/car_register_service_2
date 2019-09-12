package uph.tpsi.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uph.tpsi.models.Car;
import uph.tpsi.repositories.CarRepository;
import uph.tpsi.repositories.UserRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService
{
        private final CarRepository carRepository;

        private final UserRepository userRepository;


        @Autowired
        public CarServiceImpl ( CarRepository carRepository, UserRepository userRepository )
        {
                this.carRepository = carRepository;
                this.userRepository = userRepository;
        }

        @Override
        public List<Car> findByUser ()
        {
                String name = SecurityContextHolder.getContext().getAuthentication().getName();
                return carRepository.findAllByUser_Username( name );
        }

        @Override
        public Car create ( Car car )
        {
                car.setUser( userRepository.findByUsername( SecurityContextHolder.getContext().getAuthentication().getName() ) );
                return carRepository.save( car );
        }

        @Override
        public Car findById ( Long id )
        {
                return carRepository.findById( id ).orElseThrow( ()->new RuntimeException( "Not found" ) );
        }
}
