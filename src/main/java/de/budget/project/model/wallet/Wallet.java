package de.budget.project.model.wallet;

import de.budget.project.model.user.User;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "WALLET")
public class Wallet {

    @Id
    @GeneratedValue
    @Column(name = "WALLET_ID")
    private Long id;

    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    @OneToOne
    private User userId;

    @Column(name = "BALANCE")
    private Double balance;

    @Column(name = "CURRENCY")
    private String currency;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
}