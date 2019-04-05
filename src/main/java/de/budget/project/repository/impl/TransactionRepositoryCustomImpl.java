package de.budget.project.repository.impl;

import de.budget.project.repository.TransactionRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TransactionRepositoryCustomImpl implements TransactionRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
}
