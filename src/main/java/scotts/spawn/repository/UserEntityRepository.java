package scotts.spawn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scotts.spawn.entitiy.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);
}
