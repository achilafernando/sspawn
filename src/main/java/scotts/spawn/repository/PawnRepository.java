package scotts.spawn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scotts.spawn.entitiy.Pawn;

import java.util.List;

public interface PawnRepository extends JpaRepository<Pawn, Long> {

//    List<Pawn> FindByIdno(String Idno);

//    List<Pawn> findPawnByIDNOEqualsAndStatusEquals(String idno,int status);
    List<Pawn>  findByIdnoAndStatus(String idno, int status);
//    List<Pawn> findByIdno

    List<Pawn> findAll();
}
