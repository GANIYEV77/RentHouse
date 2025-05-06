package uz.usmon.renthouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.usmon.renthouse.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
