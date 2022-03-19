package scotts.spawn.entitiy;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@Entity
public class Pawn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PawnID;
    private String Receiptno;
    private Timestamp Pawndate;
    private String Customername;
    private String Phoneno;
    private BigDecimal Total;
    private String idno;
    private String Homeno;
    private String Street;
    private String City;
    private int status;
    private Double Totalweight;
    private Timestamp Intcaldate;
    private BigDecimal Intbalance;
    private BigDecimal Balance;
    private BigDecimal online_paid;

    @Transient
    private double interestDollars;

    @PostLoad
    private void    postLoad(){
//        this.interestDollars= this.PawnID+ 15;

        int TotMonth;

        long nYears= this.Pawndate.toLocalDateTime().until(
                LocalDateTime.now(),
                ChronoUnit.YEARS);

        long nMonths = this.Pawndate.toLocalDateTime().until(
                LocalDateTime.now(),
                ChronoUnit.MONTHS);

        long nDays = this.Pawndate.toLocalDateTime().until(
                LocalDateTime.now(),
                ChronoUnit.DAYS);


        long HalfMonthDays=Pawndate.toLocalDateTime().plusMonths(nMonths).until(LocalDateTime.now(),ChronoUnit.DAYS);

        double HalfMonthRate;
        double interestRate;

        if(Balance.doubleValue()>0 ){
            //Part Paid Pawn ticket
            if (nDays>10) {
                nDays = this.Intcaldate.toLocalDateTime().until(
                        LocalDateTime.now(),
                        ChronoUnit.DAYS);

                if (nDays <=0){
                    this.interestDollars=  Intbalance.doubleValue()  ;
                    return;
                }
                nMonths = this.Intcaldate.toLocalDateTime().until(
                        LocalDateTime.now(),
                        ChronoUnit.MONTHS);

                HalfMonthDays=Intcaldate.toLocalDateTime().plusMonths(nMonths).until(LocalDateTime.now(),ChronoUnit.DAYS);

                if  (HalfMonthDays>0){
                    nMonths+=1;
                }
                interestRate = 2.45;
                interestRate=(interestRate*nMonths);

                this.interestDollars= this.Balance.doubleValue() *(interestRate/100) ;
                this.interestDollars+= Intbalance.doubleValue() ;

                return;

            }
        }


        if(nMonths>0){
            if(HalfMonthDays<3){
                HalfMonthRate=0;
            }else if (HalfMonthDays<8){
                HalfMonthRate=1;
            }else if(HalfMonthDays<16){
                HalfMonthRate=1.7;
            }else if(HalfMonthDays<24){
                HalfMonthRate=2.1;
            }else   {
                HalfMonthRate=2.45;
            }
            interestRate = 2.45;
            interestRate=(interestRate*nMonths)+HalfMonthRate;
        }
        else{
            if (nDays<8){
                if (Total.doubleValue()<5001 ){
                    interestRate = 2.45;
                }else{
                    interestRate = 0.75;
                }
            }else{
                interestRate = 2.45;
            }
        }

        this.interestDollars= this.Total.doubleValue() *(interestRate/100) ;
        this.interestDollars+= Intbalance.doubleValue() ;

//        long nHalfMonthDays= this.Pawndate.a toLocalDateTime().until(
//                LocalDateTime.now(),
//                ChronoUnit.DAYS);

    }

    public double getInterestDollars() {
        return interestDollars;
    }

    public void setInterestDollars(double interestDollars) {
        this.interestDollars = interestDollars;
    }

}
