package ir.schoolsystem.repository.impl;

import ir.schoolsystem.model.Course;
import ir.schoolsystem.repository.CourseRepository;
import jakarta.persistence.EntityManager;

import static ir.schoolsystem.util.EntityManagerProvider.*;

import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class CourseRepositoryImpl<T> implements CourseRepository {


    @Override
    public void save(Course course) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(course);
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
            Optional<Course> course = findById(id);
            em.remove(course.get());
            transaction.commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

        }
    }

    @Override
    public void update(Course course) {
        EntityManager em = getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Optional<Course> findId = findById(course.getId());
            findId.get().setCourseTitle(course.getCourseTitle());
            findId.get().setCourseUnit(course.getCourseUnit());
            transaction.commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.ofNullable(getEntityManager().find(Course.class, id));
    }

    @Override
    public Optional<List<Course>> findAll() {
        EntityManager em = getEntityManager();
        List<Course> courses = new ArrayList<>();
        courses = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
        return Optional.ofNullable(courses);
    }


//    @Override
//    public void save(Course course) {
//        EntityManager em = getEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.persist(course);
//            em.getTransaction().commit();
//        }catch (Exception e) {
//            em.getTransaction().rollback();
//        }
//    }
//
//    @Override
//    public void Update(Long id,Course newCourse) {
//        EntityManager em = getEntityManager();
//        try {
//            em.getTransaction().begin();
//            Course course = em.find(Course.class, id);
//                course.setCourseTitle(newCourse.getCourseTitle());
//                course.setCourseUnit(newCourse.getCourseUnit());
//            em.getTransaction().commit();
//        }catch (Exception e) {
//                em.getTransaction().rollback();
//        }
//    }
//
//    @Override
//    public void delete(Long id) {
//        EntityManager em = getEntityManager();
//        try {
//            em.getTransaction().begin();
//            Course course = em.find(Course.class, id);
//            em.remove(course);
//            em.getTransaction().commit();
//        }catch (Exception e) {
//            em.getTransaction().rollback();
//
//        }
//    }
//
//    @Override
//    public Course findById(Long id) {
//        EntityManager em = getEntityManager();
//        Course course=null;
//        try {
//            em.getTransaction().begin();
//            course = em.find(Course.class, id);
//            em.getTransaction().commit();
//
//        }catch (Exception e) {
//            em.getTransaction().rollback();
//        }finally {
//            em.close();
//        }
//        return course;
//    }
//
//    @Override
//    public List<Course> findAll() {
//        EntityManager em=getEntityManager();
//        List<Course> courseList=new ArrayList<>();
//        try {
//            em.getTransaction().begin();
//            courseList = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
//            em.getTransaction().commit();
//        }catch (Exception e) {
//            em.getTransaction().rollback();
//        }finally {
//            em.close();
//        }
//        return courseList;
//    }


}
