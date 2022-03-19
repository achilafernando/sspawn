package scotts.spawn.entitiy;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

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
    private BigDecimal PaidAmount;
    @CreationTimestamp
    private LocalDateTime PaidDate;
    private String mobile;
    private  String bankref;

}
