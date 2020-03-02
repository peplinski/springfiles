package pl.springboot.file.services;


import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.Schedule;
import pl.springboot.file.model.TypRozkladu;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    List<Schedule> findAll();

    Schedule save(Schedule schedule);

    List<Schedule> findByDate(String date);


    boolean saveDataFromCsv(MultipartFile file, String date, TypRozkladu typRozkladu);

    void deleteById(String id);

    Optional<Schedule> findById(String id);

}

