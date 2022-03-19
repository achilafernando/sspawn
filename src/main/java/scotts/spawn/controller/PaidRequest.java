package scotts.spawn.controller;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PaidRequest {
    private Long pawnid;
    private BigDecimal paid_amount;
}
