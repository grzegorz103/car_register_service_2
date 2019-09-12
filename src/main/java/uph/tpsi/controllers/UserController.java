package uph.tpsi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uph.tpsi.models.User;
import uph.tpsi.services.UserService;

@RestController
@RequestMapping ("/api/users")
@CrossOrigin
public class UserController
{
        private final UserService userService;

        @Autowired
        public UserController ( UserService userService )
        {
                this.userService = userService;
        }

        @PostMapping ("/login")
        public boolean login ( String username, String password )
        {
                return userService.isLoginCorrect( username, password );
        }

        @PostMapping
        public User create ( @RequestBody User user )
        {
                return userService.create( user );
        }

}