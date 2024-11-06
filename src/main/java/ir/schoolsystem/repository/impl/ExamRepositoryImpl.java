package ir.schoolsystem.repository.impl;

import ir.schoolsystem.model.Exam;
import ir.schoolsystem.repository.ExamRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import static ir.schoolsystem.util.EntityManagerProvider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ExamRepositoryImpl implements ExamRepository {


    @Override
    public void save(Exam exam) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(exam);
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
            Optional<Exam> exam = findById(id);
                em.remove(exam.get());
               transaction.commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Exam exam) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Optional<Exam> findId = findById(exam.getId());
                findId.get().setExamtitle(exam.getExamtitle());
                findId.get().setExamDate(exam.getExamDate());
                findId.get().setExamTime(exam.getExamTime());
                findId.get().setCourse(exam.getCourse());
            transaction.commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return Optional.ofNullable(getEntityManager().find(Exam.class, id));
    }

    @Override
    public Optional<List<Exam>> findAll() {
        EntityManager em = getEntityManager();
        List<Exam> exams = new ArrayList<>();
        exams = em.createQuery("SELECT e FROM Exam e", Exam.class).getResultList();
        return Optional.ofNullable(exams);
    }
}
