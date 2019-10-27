package pl.springboot.file.repository;

import org.springframework.data.repository.CrudRepository;
import pl.springboot.file.model.RodzajRozkladu;

public interface RozkladRepository extends CrudRepository<RodzajRozkladu,Long> {
}
