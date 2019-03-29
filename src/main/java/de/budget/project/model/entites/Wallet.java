package de.budget.project.model.entites;

import de.budget.project.model.types.CurrencyConverter;
import de.budget.project.model.types.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "WALLET")
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @Column(name = "CURRENCY_TYPE")
    @Convert(converter = CurrencyConverter.class)
    private CurrencyType currencyType;
}