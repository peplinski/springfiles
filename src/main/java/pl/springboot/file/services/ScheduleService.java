package pl.springboot.file.services;


import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAll();


    boolean saveDataFromCsv(MultipartFile file, String date, String rozklad);
}

