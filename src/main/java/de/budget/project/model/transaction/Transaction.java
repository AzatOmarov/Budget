package de.budget.project.model.transaction;

import de.budget.project.model.wallet.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTION_ID")
    private Long id;

//    @Column(name = "DATE", nullable = false)
//    private Date date;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "WALLET_ID", nullable = false, unique = true)
    private Wallet walletId;

//    @JoinColumn(name = "CATEGORY_ID", nullable = false, unique = true)
//    @OneToOne
//    private Category categoryId;

    @Column(name = "DESCRIPTION")
    private String description;

    @CreationTimestamp
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
}