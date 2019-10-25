package pl.springboot.file.services;


import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.Schedule;

import java.util.List;

public interface SpringReadFileService {
    List<Schedule> findAll();


    boolean saveDataFromUploadFile(MultipartFile file);
}

