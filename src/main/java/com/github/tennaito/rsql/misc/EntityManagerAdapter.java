package com.github.tennaito.rsql.misc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;

import java.util.function.Supplier;

public final class EntityManagerAdapter {

    Supplier<Metamodel> metamodelSupplier;

    Supplier<CriteriaBuilder> criteriaBuilderSupplier;

    public EntityManagerAdapter(EntityManager entityManager) {
        this(entityManager::getMetamodel, entityManager::getCriteriaBuilder);
    }

    public EntityManagerAdapter(Supplier<Metamodel> metamodelSupplier, Supplier<CriteriaBuilder> criteriaBuilderSupplier) {
        this.metamodelSupplier = metamodelSupplier;
        this.criteriaBuilderSupplier = criteriaBuilderSupplier;
    }


    public Metamodel getMetamodel() {
        return metamodelSupplier.get();
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return criteriaBuilderSupplier.get();
    }
}