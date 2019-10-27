package pl.springboot.file.services;

import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.RodzajRozkladu;

import java.util.List;

public interface RozkladService {
    List<RodzajRozkladu> findAll();
    boolean saveDataFromUploadFile(MultipartFile file);

    boolean save(RodzajRozkladu rodzajRozkladu);
}
