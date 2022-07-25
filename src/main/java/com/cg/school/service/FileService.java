package com.cg.school.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileService {

    void saveFile(MultipartFile multipartFile, Path path);
}
