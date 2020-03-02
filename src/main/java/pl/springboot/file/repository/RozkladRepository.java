package pl.springboot.file.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.springboot.file.model.RodzajRozkladu;
import pl.springboot.file.model.Schedule;

import java.util.Optional;

@Repository
public interface RozkladRepository extends CrudRepository<RodzajRozkladu,Long> {

    String findAllByTypRozkladuAndLiniaAndGodzina(String typRozkladu, String startLine, String godz);

    Optional<Schedule> findById(String id);
}
