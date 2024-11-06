package ir.schoolsystem.repository.impl;

import ir.schoolsystem.model.Teacher;
import ir.schoolsystem.repository.TeacherRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.apache.commons.beanutils.BeanUtils;

import static ir.schoolsystem.util.EntityManagerProvider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class TeacherRepositoryImpl implements TeacherRepository {


    @Override
    public void save(Teacher teacher) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Optional<Teacher> teacher = findById(id);
            em.remove(teacher.get());
            transaction.commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Teacher teacher) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Optional<Teacher> findId = findById(teacher.getId());
                findId.get().setFirstName(teacher.getFirstName());
                findId.get().setLastName(teacher.getLastName());
                findId.get().setNationalCode(teacher.getNationalCode());
                findId.get().setCourse(teacher.getCourse());
            transaction.commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return Optional.ofNullable(getEntityManager().find(Teacher.class, id));
    }

    @Override
    public Optional<List<Teacher>> findAll() {
        EntityManager em = getEntityManager();
        List<Teacher> teachers = new ArrayList<>();
        teachers = em.createQuery("select t from Teacher t", Teacher.class).getResultList();
        return Optional.ofNullable(teachers);
    }
}
