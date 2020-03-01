package pl.springboot.file.services;


import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.Schedule;
import pl.springboot.file.model.TypRozkladu;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAll();

    List<Schedule> findByDate(String date);


    boolean saveDataFromCsv(MultipartFile file, String date, TypRozkladu typRozkladu);
}

