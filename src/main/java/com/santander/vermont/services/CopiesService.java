package com.santander.vermont.services;

import java.io.File;
import java.io.IOException;
import java.lang.Exception;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CopiesService {

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
            copyFileInBackground(file, fileName);
        } catch (Exception e) {
            System.err.println("Error during file copying: " + e.getMessage());
        }
    }

    @Async("asyncExecutor")
    private void copyFileInBackground(MultipartFile file, String fileName) {
        try {
            // Realiza la copia del archivo
            file.transferTo(new File(fileName));
            System.out.println("File copied to: " + fileName);
        } catch (IOException e) {
            System.err.println("Error during file copying: " + e.getMessage());
        }
    }
}
