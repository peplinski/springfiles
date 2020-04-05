package pl.springboot.file.repository;

import org.springframework.data.repository.CrudRepository;
import pl.springboot.file.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
