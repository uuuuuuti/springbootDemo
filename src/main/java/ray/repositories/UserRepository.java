package ray.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import ray.models.User;

/**
 * Created by zr on 2016/11/9.
 */
public interface UserRepository extends MongoRepository<User,String>{
    User findByUsername(String username);
    User findByEmail(String email);
}
