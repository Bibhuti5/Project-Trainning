package com.cg.school.service;

import com.cg.school.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class RegistrationServiceImpl extends UserService {

    @Autowired
    private FileService fileService;

    @Override
    public void registerUser(Student student) {
        //TODO Add code to store user basic details like name, address etc

        // 2L should be replaced by dynamic user id which will be generated after storing user details
        fileService.saveFile(student.getPhoto().getFile(),getFilePath("F:\\TEST",
                student.getPhoto().getDocumentType(),2L));
    }

    private Path getFilePath(String basePath,String documentType,Long id){
        Path path= Paths.get(basePath);
        return path.resolve(String.valueOf(id)).resolve(documentType);
    }
}