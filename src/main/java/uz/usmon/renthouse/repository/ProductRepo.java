package uz.usmon.renthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmon.renthouse.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
