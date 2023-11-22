package com.santander.vermont.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.santander.vermont.services.CopiesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/copy")
@RequiredArgsConstructor
public class CopiesController {
    // Inyección de dependencias alternativo gracias a Lombok
    private final CopiesService service;

    @PostMapping()
    public ResponseEntity<String> copyFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("No se proporcionó un archivo para copiar.", HttpStatus.BAD_REQUEST);
        }
        this.service.copyFileAsync(file);
        return new ResponseEntity<>("Se ha copiado el archivo.", HttpStatus.OK);
    }
}
