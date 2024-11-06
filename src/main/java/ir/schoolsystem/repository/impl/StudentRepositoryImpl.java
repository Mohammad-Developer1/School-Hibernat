package ir.schoolsystem.repository.impl;

import ir.schoolsystem.model.Student;
import ir.schoolsystem.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import static ir.schoolsystem.util.EntityManagerProvider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class StudentRepositoryImpl implements StudentRepository {


    @Override
    public void save(Student student) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
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
            Optional<Student> student = findById(id);
                em.remove(student.get());
                transaction.commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Student student) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
           transaction.begin();
            Optional<Student> findID = findById(student.getId());
                findID.get().setFirstName(student.getFirstName());
                findID.get().setLastName(student.getLastName());
                findID.get().setNationalCode(student.getNationalCode());
                findID.get().setScore(student.getScore());
            transaction.commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(getEntityManager().find(Student.class, id));
    }

    @Override
    public Optional<List<Student>> findAll() {
        EntityManager em = getEntityManager();
        List<Student> students = new ArrayList<>();
        students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        return Optional.ofNullable(students);
    }
}
