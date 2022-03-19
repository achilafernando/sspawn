package scotts.spawn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scotts.spawn.entitiy.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
