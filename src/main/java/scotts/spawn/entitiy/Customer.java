package scotts.spawn.entitiy;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @Transient
    private double interestDollars;

    @PostLoad
    private void    postLoad(){
        this.interestDollars= this.id+ 15;
    }

    public double getInterestDollars() {
        return interestDollars;
    }

    public void setInterestDollars(double interestDollars) {
        this.interestDollars = interestDollars;
    }

}
