package de.budget.project.model.transaction;

import de.budget.project.model.category.Category;
import de.budget.project.model.user.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTION_ID")
    private Long id;

    @Column(name = "DATE", nullable = false)
    private Date date;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    @OneToOne
    private User userId;

    @JoinColumn(name = "CATEGORY_ID", nullable = false, unique = true)
    @OneToOne
    private Category categoryId;

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