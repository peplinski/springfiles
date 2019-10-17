package pl.springboot.file.services;


import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.User;

import java.util.List;

public interface SpringReadFileService {
    List<User> findAll();


    boolean saveDataFromUploadFile(MultipartFile file);
}

