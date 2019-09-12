package uph.tpsi.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import uph.tpsi.models.User;

public interface UserService extends UserDetailsService
{
        User create(User user);

        boolean isLoginCorrect ( String username, String password );
}
