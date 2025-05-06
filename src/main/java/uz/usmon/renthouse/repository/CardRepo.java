package uz.usmon.renthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmon.renthouse.model.Card;

public interface CardRepo extends JpaRepository<Card, Integer> {
}
