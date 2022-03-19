package scotts.spawn.service;

import scotts.spawn.entitiy.OnlinePayments;

import java.util.List;

public interface OnlinePaymentService {

    OnlinePayments FindPaymnetById(Long Id);
    List<OnlinePayments> FindAllPaymnets();
    OnlinePayments SavePaymnet (OnlinePayments onlinePayments);

}
