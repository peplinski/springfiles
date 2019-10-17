package pl.springboot.file.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.springboot.file.model.User;

@Repository
public interface SpringReadFileRepository extends CrudRepository<User,Long> {

}
