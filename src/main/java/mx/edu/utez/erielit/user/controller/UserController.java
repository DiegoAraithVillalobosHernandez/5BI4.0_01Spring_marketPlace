package mx.edu.utez.erielit.user.controller;

import mx.edu.utez.erielit.user.model.User;
import mx.edu.utez.erielit.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return userService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody UserDTO user){
        System.out.println("Hola Diego");
        return userService.save(
                new User(user.getUsername(),
                        passwordEncoder.encode(user.getPassword()),
                        user.getPerson(),
                        user.getRoles()));
    }
}
