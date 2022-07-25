package com.cg.school.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class WindowsFileServiceImpl implements FileService {
    @Override
    public void saveFile(MultipartFile multipartFile, Path path) {
        try {
            File directory=new File(path.toString());
            if(!directory.exists())
                directory.mkdirs();
            Files.write(path.resolve(multipartFile.getOriginalFilename()),
                    multipartFile.getBytes());
        } catch (IOException e) {
            System.out.println("Error while storing file "+e);
        }
    }
}