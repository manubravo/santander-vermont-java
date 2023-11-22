package com.santander.vermont.services;

import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santander.vermont.dto.UsersDto;
import com.santander.vermont.entities.UsersEntity;
import com.santander.vermont.repositories.UsersRepository;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
    // Inyección de dependencias alternativo gracias a Lombok
    private final UsersRepository repository;
    private Logger logger = LoggerFactory.getLogger(UsersService.class);

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
    @Transactional(readOnly = true) //Guarantee that the reading of users from the database is a read-only operation
    private List<UsersDto> getAllUsers() {
        List<UsersEntity> entityList = this.repository.findAll();
        return this.mapEntityListToDtoList(entityList);
    }

    public void getUsersCSV(HttpServletResponse response) {
        this.logger.info("Creating CSV file...");
        try (PrintWriter pw = response.getWriter()) {
            response.setContentType("text/csv");
            // Generate unique file name
            String fileName = "users.csv";
            this.logger.info("CSV name:" + fileName);
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName);
            // Writing users data...
            this.getAllUsers().forEach(user -> pw.println(user));
            this.logger.info("CSV file generated and downloaded successfully");
        } catch (Exception e) {
            logger.error("Error while generating and downloading CSV file: " + e.getMessage());
        }
    }
}
