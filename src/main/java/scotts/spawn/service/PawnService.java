package scotts.spawn.service;

import org.springframework.stereotype.Service;
import scotts.spawn.entitiy.Pawn;

import java.util.List;


public interface PawnService {
    Pawn findPawnById(Long id);
    List<Pawn> findAllPawn();
    List<Pawn> findPawnByIDNO(String idno,int status);

    Pawn savePawn(Pawn pawn);

}
