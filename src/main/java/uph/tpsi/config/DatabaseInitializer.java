package uph.tpsi.config;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import uph.tpsi.models.Car;
import uph.tpsi.models.User;
import uph.tpsi.models.UserRole;
import uph.tpsi.repositories.CarRepository;
import uph.tpsi.repositories.UserRepository;
import uph.tpsi.repositories.UserRoleRepository;

import java.util.Collections;
import java.util.HashSet;

@Configuration
public class DatabaseInitializer
{
        private final UserRepository userRepository;

        private final CarRepository carRepository;

        private final PasswordEncoder encoder;

        @Autowired
        private UserRoleRepository userRoleRepository;

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

                        if ( userRoleRepository.findAll().isEmpty() )
                        {
                                userRoleRepository.save( new UserRole( 1L, UserRole.UserType.ROLE_USER ) );
                                userRoleRepository.save( new UserRole( 2L, UserRole.UserType.ROLE_ADMIN ) );
                        }
                        if ( userRepository.findAll().isEmpty() )
                        {
                                userRepository.save(
                                        User.builder().cars( new HashSet<>() )
                                                .username( "usertest" )
                                                .userRoles( new HashSet<>( Collections.singletonList( userRoleRepository.findByUserType( UserRole.UserType.ROLE_USER ) ) ) )
                                                .password( encoder.encode( "usertest" ) )
                                                .build()
                                );

                                userRepository.save(
                                        User.builder().cars( new HashSet<>() )
                                                .username( "admin" )
                                                .password( encoder.encode( "admin" ) )
                                                .userRoles( new HashSet<>( Collections.singletonList( userRoleRepository.findByUserType( UserRole.UserType.ROLE_ADMIN ) ) ) )
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
