package uz.usmon.renthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmon.renthouse.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {
}
