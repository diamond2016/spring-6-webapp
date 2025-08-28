package guru.springframework.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
