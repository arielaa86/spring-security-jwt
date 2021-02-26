package io.javabrains.springsecurityjwt.controller;


import io.javabrains.springsecurityjwt.domain.User;
import io.javabrains.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping({"","/page/{page}"})
    public List<User> index(@PathVariable("page") Optional<Integer> page){

        if(page.isPresent()){
           return userService.getAll(page.get(), 5);
        }

        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User show(@PathVariable("id") Long id){
        return userService.get(id);
    }


    @PostMapping("")
    public User save(@RequestBody User user){
        return userService.save(user);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }


}
