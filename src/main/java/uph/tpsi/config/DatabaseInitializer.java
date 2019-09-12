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
public class DatabaseInitializer
{
        private final UserRepository userRepository;

        private final CarRepository carRepository;

        private final PasswordEncoder encoder;

        @Autowired
        public DatabaseInitializer ( UserRepository userRepository, PasswordEncoder encoder, CarRepository carRepository )
        {
                this.userRepository = userRepository;
                this.encoder = encoder;
                this.carRepository = carRepository;
        }

        @Bean
        public InitializingBean initializingBean ()
        {
                return () -> {

                        if ( userRepository.findAll().isEmpty() )
                        {
                                userRepository.save(
                                        User.builder().cars( new HashSet<>() )
                                                .username( "usertest" )
                                                .password( encoder.encode( "usertest" ) )
                                                .build()
                                );
                        }
                        if ( carRepository.findAll().isEmpty() )
                        {
                                carRepository.save( Car.builder().brand( "Volkswagen" ).mileage( 10000 ).model( "Gold" ).registerNumber( "WSI212EF" ).user( userRepository.findByUsername( "usertest" ) ).year( 2015 ).carType( "Sedan" ).build() );
                                carRepository.save( Car.builder().brand( "Fiat" ).mileage( 200000 ).model( "Panda" ).registerNumber( "WSI92OFP" ).user( userRepository.findByUsername( "usertest" ) ).year( 2013 ).carType( "Sedan" ).build() );
                        }
                };
        }
}
