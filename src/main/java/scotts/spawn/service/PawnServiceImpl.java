package scotts.spawn.service;

import org.springframework.stereotype.Service;
import scotts.spawn.entitiy.Pawn;
import scotts.spawn.repository.PawnRepository;

import java.util.List;

@Service
public class PawnServiceImpl implements PawnService {

    private final PawnRepository pawnRepository;

    public PawnServiceImpl(PawnRepository pawnRepository) {
        this.pawnRepository = pawnRepository;
    }


    @Override
    public Pawn findPawnById(Long id) {
        return pawnRepository.findById(id).get();

    }

    @Override
    public List<Pawn> findAllPawn() {
        return pawnRepository.findAll();
    }

    @Override
    public List<Pawn> findPawnByIDNO(String idno,int status) {
        return pawnRepository.findByIdnoAndStatus(idno,status);
    }

    @Override
    public Pawn savePawn(Pawn pawn) {
        return pawnRepository.save(pawn);
    }


}
