package scotts.spawn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scotts.spawn.entitiy.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByName(String name);
}
