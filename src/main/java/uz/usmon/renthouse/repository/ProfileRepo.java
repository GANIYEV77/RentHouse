package uz.usmon.renthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmon.renthouse.model.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Integer> {
}
