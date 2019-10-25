package pl.springboot.file.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.springboot.file.model.Schedule;
@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,Long> {

}
