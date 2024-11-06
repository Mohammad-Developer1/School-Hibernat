package ir.schoolsystem.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class EntityManagerProvider {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc-postgres");
    @Getter
    private static final EntityManager entityManager = emf.createEntityManager();


}
