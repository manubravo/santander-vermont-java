package com.santander.vermont.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.santander.vermont.dto.UsersDto;
import com.santander.vermont.entities.UsersEntity;
import com.santander.vermont.repositories.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
    // Inyección de dependencias alternativo gracias a Lombok
    private final UsersRepository repository;

    // Mapping Entity to DTO
    private UsersDto mapEntityToDto(UsersEntity entity) {
        UsersDto dto = new UsersDto();
        // Ommiting sensitive information
        BeanUtils.copyProperties(entity, dto, "id");
        return dto;
    }

    // Mapping ListEntity to ListDto using Stream and Lambda
    private List<UsersDto> mapEntityListToDtoList(List<UsersEntity> entityList) {
        return entityList.stream()
                .map(entity -> this.mapEntityToDto(entity))
                .collect(Collectors.toList());
    }

    // ListDto
    private List<UsersDto> getAllUsers() {
        List<UsersEntity> entityList = this.repository.findAll();
        return this.mapEntityListToDtoList(entityList);
    }

    public void getUsersCSV() {
        System.out.println("Creating CSV file...");
        int counter = 0;
        String baseFileName = "users.csv";
        String fileName;
        do {
            fileName = (counter == 0) ? baseFileName : "users(" + counter + ").csv";
            counter++;
        } while (new File(fileName).exists());
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, true))) {
            this.getAllUsers().forEach(user -> pw.println(user));
            System.out.println("You have created a CSV file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
