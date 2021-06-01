package lt.finalproject.eshop.repo;

import lt.finalproject.eshop.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
