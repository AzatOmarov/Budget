package de.budget.project.model.user;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue()
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME", length = 50)
    private String name;

    @Column(name = "PASSWORD", nullable = false, length = 50)
    private String password;

    @Column(name = "EMAIL", nullable = false, length = 50, unique = true)
    private String email;

    @CreationTimestamp
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
}