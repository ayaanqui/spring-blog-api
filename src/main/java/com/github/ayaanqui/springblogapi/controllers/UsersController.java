package com.github.ayaanqui.springblogapi.controllers;

import java.util.Optional;

import com.github.ayaanqui.springblogapi.models.User;
import com.github.ayaanqui.springblogapi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(path = "/users")
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    private class Response {
        private final String message;

        public Response(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    @PostMapping("")
    public @ResponseBody Response postNewUser(@RequestParam String name, @RequestParam String email,
            @RequestParam String username) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);

        userRepository.save(user);
        return new Response("User created successfully!");
    }

    @GetMapping("")
    public @ResponseBody Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/")
    public @ResponseBody Optional<User> getUser(@RequestParam int id) {
        return userRepository.findById(id);
    }
}
