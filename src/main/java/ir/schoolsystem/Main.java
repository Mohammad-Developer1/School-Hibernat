package ir.schoolsystem;

import ir.schoolsystem.model.Course;
import ir.schoolsystem.model.Student;
import ir.schoolsystem.repository.CourseRepository;
import ir.schoolsystem.repository.ExamRepository;
import ir.schoolsystem.repository.StudentRepository;
import ir.schoolsystem.repository.impl.CourseRepositoryImpl;
import ir.schoolsystem.repository.impl.ExamRepositoryImpl;
import ir.schoolsystem.repository.impl.StudentRepositoryImpl;
import ir.schoolsystem.service.CourseService;
import ir.schoolsystem.service.ExamService;
import ir.schoolsystem.service.impl.CourseServiceImpl;
import ir.schoolsystem.service.impl.ExamServiceImpl;
import ir.schoolsystem.util.ApplicationContext;
import jakarta.persistence.EntityManager;

import static ir.schoolsystem.util.EntityManagerProvider.*;

public class Main {
    public static void main(String[] args) {


//        ApplicationContext.getExamService().printAll();
//        ApplicationContext.getStudentService().printAll();
//        ApplicationContext.getCourseService().printAll();
//        ApplicationContext.getTeacherService().printAll();
//        ApplicationContext.getCourseService().save(Course.builder().courseTitle("11111111").courseUnit(5).build());
//            ApplicationContext.getCourseService().delete(1L);
//
//        ApplicationContext.getStudentService().update(Student.builder().Id(3L).firstName("MM").lastName("mamad").build());
        ApplicationContext.getStudentService().printAll();
    }
}
