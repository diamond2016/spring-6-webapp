package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
