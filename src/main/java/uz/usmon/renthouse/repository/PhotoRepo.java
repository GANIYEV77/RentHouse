package uz.usmon.renthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmon.renthouse.model.Photo;

public interface PhotoRepo extends JpaRepository<Photo, Integer> {
}
