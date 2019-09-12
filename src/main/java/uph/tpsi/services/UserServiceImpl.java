package uph.tpsi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uph.tpsi.models.User;
import uph.tpsi.repositories.UserRepository;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService
{
        private final UserRepository userRepository;

        @Autowired
        private BCryptPasswordEncoder encoder;

        @Autowired
        public UserServiceImpl ( UserRepository userRepository )
        {
                this.userRepository = userRepository;
        }

        @Override
        public UserDetails loadUserByUsername ( String s ) throws UsernameNotFoundException
        {
                User user = userRepository.findByUsername( s );
                if ( user == null )
                        throw new UsernameNotFoundException( "User not found" );

                return new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton( new SimpleGrantedAuthority( "USER" ) )
                );
        }

        @Override
        public User create ( User user )
        {
                user.setPassword( encoder.encode( user.getPassword() ) );
                user.setCars( new HashSet<>() );
                return userRepository.save( user );
        }

        @Override
        public boolean isLoginCorrect ( String username, String password )
        {
                User u = userRepository.findByUsername( username );
                if ( u == null )
                {
                        return false;
                }

                return u.getUsername().equals( username )
                        && encoder.matches( password, u.getPassword() );
        }
}
