package com.santander.vermont.services;

import java.io.File;
import java.io.IOException;
import java.lang.Exception;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CopiesService {

    private Logger logger = LoggerFactory.getLogger(CopiesService.class);

    @Async("asyncExecutor")
    public void copyFileAsync(MultipartFile file) {
        try {
            // Destino en la raíz del proyecto
            String destinationDirectory = System.getProperty("user.dir") + File.separator + "copies";
            File copiesDirectory = new File(destinationDirectory);
            if (!copiesDirectory.exists()) {
                copiesDirectory.mkdirs();
            }
            // Nombre de archivo en la carpeta "copies"
            String fileName = destinationDirectory + File.separator + file.getOriginalFilename();
            // Ejecución de la copia en un hilo independiente
            new Thread(()->this.readAndCopyFile(file, fileName)).start();
        } catch (Exception e) {
            this.logger.error("Error during file copying: " + e.getMessage());
        }
    }
    
    private void readAndCopyFile(MultipartFile file, String fileName) {
        try {
            this.logger.info("Start Read Thread");
            // Lee el contenido del archivo
            byte[] fileBytes = file.getBytes();
            // Inicia la escritura del archivo en un hilo independiente
            new Thread(() -> writeToFile(fileBytes, fileName)).start();
            this.logger.info("Finish Read Thread");
        } catch (IOException e) {
            this.logger.error("Error during file reading: " + e.getMessage());
        }
    }

    private void writeToFile(byte[] fileBytes, String fileName) {
        try {
            this.logger.info("Start Write Thread");
            // Escribe el contenido del archivo en el nuevo archivo
            Path filePath = Path.of(fileName);
            Files.write(filePath, fileBytes);
            this.logger.info("File copied to: " + fileName);
            this.logger.info("Finish Write Thread");
        } catch (IOException e) {
            this.logger.error("Error during file writing: " + e.getMessage());
        }
    }
}
