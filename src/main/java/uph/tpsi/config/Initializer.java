package uph.tpsi.config;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import uph.tpsi.models.Car;
import uph.tpsi.models.User;
import uph.tpsi.repositories.CarRepository;
import uph.tpsi.repositories.UserRepository;

import java.util.HashSet;

@Configuration
public class Initializer
{
        private final UserRepository userRepository;

        private final CarRepository carRepository;

        private final PasswordEncoder encoder;

        @Autowired
        private CarTypeRepository carTypeRepository;

        @Autowired
        public Initializer ( UserRepository userRepository, PasswordEncoder encoder, CarRepository carRepository )
        {
                this.userRepository = userRepository;
                this.encoder = encoder;
                this.carRepository = carRepository;
        }

        @Bean
        public InitializingBean initializingBean ()
        {
                return () -> {

                        if ( carTypeRepository.findAll().isEmpty() )
                        {
                                carTypeRepository.save( new CarType( 1L, "VAN", new HashSet<>() ) );
                                carTypeRepository.save( new CarType( 2L, "Sedan", new HashSet<>() ) );
                                carTypeRepository.save( new CarType( 3L, "Sport", new HashSet<>() ) );
                        }


                        if ( userRepository.findAll().isEmpty() )
                        {
                                userRepository.save(
                                        User.builder().cars( new HashSet<>() )
                                                .username( "user1" )
                                                .password( encoder.encode( "user1" ) )
                                                .build()
                                );
                        }
                        if ( carRepository.findAll().isEmpty() )
                        {
                                carRepository.save( Car.builder().brand( "Ford" ).mileage( 10000 ).model( "Mustang" ).registerNumber( "WM502DD" ).user( userRepository.findByUsername( "user1" ) ).year( 2013 ).carType( carTypeRepository.findById( 3L ).get() ).build() );
                        }
                };
        }
}
