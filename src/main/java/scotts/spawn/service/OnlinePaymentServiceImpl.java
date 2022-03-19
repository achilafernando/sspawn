package scotts.spawn.service;

import org.springframework.stereotype.Service;
import scotts.spawn.entitiy.OnlinePayments;
import scotts.spawn.repository.OnlinePaymentsRepository;

import java.util.List;

@Service
public class OnlinePaymentServiceImpl implements OnlinePaymentService {
    private final OnlinePaymentsRepository onlinePaymentsRepository;

    public OnlinePaymentServiceImpl(OnlinePaymentsRepository onlinePaymentsRepository) {
        this.onlinePaymentsRepository = onlinePaymentsRepository;
    }

    @Override
    public OnlinePayments FindPaymnetById(Long Id) {
        return onlinePaymentsRepository.findById(Id).get();
    }

    @Override
    public List<OnlinePayments> FindAllPaymnets() {
        return onlinePaymentsRepository.findAll();
    }

    @Override
    public OnlinePayments SavePaymnet(OnlinePayments onlinePayments) {
        return onlinePaymentsRepository.save(onlinePayments);
    }
}
