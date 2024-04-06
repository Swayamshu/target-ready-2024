package com.targetindia.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class JPAUtil {
    private static final EntityManagerFactory emf;
    private JPAUtil() {
    }

    static {
        emf = Persistence.createEntityManagerFactory("JPA-BASICS");
    }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}
