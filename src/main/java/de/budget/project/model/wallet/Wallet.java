package de.budget.project.model.wallet;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "WALLET")
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue
    @Column(name = "WALLET_ID")
    private Long id;

    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    @OneToOne
    private User userId;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @Column(name = "CURRENCY")
    private String currency;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @OneToMany(mappedBy = "walletId")
    private Set<Transaction> transactions = new HashSet<Transaction>();

}