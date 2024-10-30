package ru.netology.authorizationservice.controller;



import org.springframework.web.bind.annotation.*;
import ru.netology.authorizationservice.service.AuthorizationService;
import ru.netology.authorizationservice.model.Authorities;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user,
                                            @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
