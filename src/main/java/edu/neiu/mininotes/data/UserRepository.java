package edu.neiu.mininotes.data;

import edu.neiu.mininotes.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {


    User findByUsername(String username);
}
