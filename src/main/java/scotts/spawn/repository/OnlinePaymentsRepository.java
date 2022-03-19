package scotts.spawn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scotts.spawn.entitiy.OnlinePayments;

public interface OnlinePaymentsRepository extends JpaRepository<OnlinePayments,Long> {

}
