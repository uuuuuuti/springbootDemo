package ray.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ray.models.Post;

/**
 * Created by zr on 2016/11/11.
 */
public interface PostRepository extends MongoRepository<Post,String>{

}
