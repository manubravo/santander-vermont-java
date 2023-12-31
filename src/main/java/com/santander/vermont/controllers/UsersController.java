package com.santander.vermont.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.vermont.services.UsersService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    // Inyección de dependencias alternativo gracias a Lombok
    private final UsersService service;

    @GetMapping()
    public void getAll(HttpServletResponse response) {
        this.service.getUsersCSV(response);
    }
}
