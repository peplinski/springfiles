package pl.springboot.file.services;


import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.Schedule;
import pl.springboot.file.model.TypRozkladu;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ScheduleService {
    List<Schedule> findAll();

    void deleteById(Long idToDelete);

    Schedule save(Schedule schedule);

    List<Schedule> findByDate(String date);


    boolean saveDataFromCsv(MultipartFile file, String date, TypRozkladu typRozkladu);

    Optional<Schedule> findById(Long id);

    Set<Schedule> findScheduleByNrSluzbowy(String nrSluzbowy);
}

