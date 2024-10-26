package alex.blog.repository;

import alex.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository <Post, Integer> {
}
