package pl.springboot.file.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.springboot.file.model.Schedule;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,Long> {
List<Schedule> findScheduleByNrSluzbowy(String nrSluzbowy);
}
