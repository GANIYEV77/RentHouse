package uz.usmon.renthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmon.renthouse.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
}
