package scotts.spawn.entitiy;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import sun.java2d.pipe.SpanIterator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Online_Payments")
public class OnlinePayments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private long PawnId;
    private String nic_no;
    private String mobile;
    private BigDecimal pawn_amount;
    private BigDecimal payable_amount;
    private BigDecimal c_card_commision;
    private BigDecimal total_paid;
    private  String trn_ref_no;
    @CreationTimestamp
    private LocalDateTime paid_date;
    @CreationTimestamp
    private LocalDateTime serverdate;
    private int status;
    private BigDecimal paidamount;
    private String bankref;

}
