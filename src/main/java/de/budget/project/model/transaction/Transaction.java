package de.budget.project.model.transaction;

import de.budget.project.model.category.Category;
import de.budget.project.model.wallet.Wallet;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.JoinColumn;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "TRANSACTION")
public class Transaction {

    public Transaction(Date customDate, Float amount, Wallet wallet, Category category, String description) {
        this.customDate = customDate;
        this.amount = amount;
        this.wallet = wallet;
        this.category = category;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CUSTOM_DATE", nullable = false)
    private Date customDate;

    @Column(name = "AMOUNT", nullable = false)
    private Float amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WALLET_ID", referencedColumnName = "ID")
    private Wallet wallet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;

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