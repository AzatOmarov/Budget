package de.budget.project.model.wallet;

import de.budget.project.model.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "WALLET")
@RequiredArgsConstructor
public class Wallet {

    public Wallet(User user, String currency) {
        this.user = user;
        this.currency = currency;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "CURRENCY")
    private String currency;
}