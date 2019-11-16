package pl.springboot.file.repository;

import org.springframework.data.repository.CrudRepository;
import pl.springboot.file.model.RodzajRozkladu;

import java.util.List;

public interface RozkladRepository extends CrudRepository<RodzajRozkladu,Long> {
    List<RodzajRozkladu> findAllByTypRozkladu(String typRozkladu);
   // String findAllByTypRozkladu(String typRozkladu, String firstlinia, String startgodzina);
}
