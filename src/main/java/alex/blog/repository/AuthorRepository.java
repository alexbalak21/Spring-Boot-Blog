package alex.blog.repository;

import alex.blog.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Integer> {
}
