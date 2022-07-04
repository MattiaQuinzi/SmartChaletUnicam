package it.unicam.cs.SmartChaletUnicam.Controller;

import it.unicam.cs.SmartChaletUnicam.Model.Notifica;
import it.unicam.cs.SmartChaletUnicam.Model.User;
import it.unicam.cs.SmartChaletUnicam.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "smartchaletunicam/users")
public class ControllerUser {

    @Autowired
    private ServiceUser serviceUser;

    @GetMapping("/getusers")
    public List<User> getUsers(){
        return serviceUser.getUsers();
    }

    @GetMapping("/getuserbymail")
    public User getUserByMail(@RequestBody User user) {
        return serviceUser.getUserByMail(user);
    }

    @GetMapping("/login")
    public User login(@RequestBody User user) {
        return serviceUser.login(user);
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return serviceUser.createUser(user);
    }

}
