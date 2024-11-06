package ir.schoolsystem.util;

import ir.schoolsystem.repository.CourseRepository;
import ir.schoolsystem.repository.ExamRepository;
import ir.schoolsystem.repository.StudentRepository;
import ir.schoolsystem.repository.TeacherRepository;
import ir.schoolsystem.repository.impl.CourseRepositoryImpl;
import ir.schoolsystem.repository.impl.ExamRepositoryImpl;
import ir.schoolsystem.repository.impl.StudentRepositoryImpl;
import ir.schoolsystem.repository.impl.TeacherRepositoryImpl;
import ir.schoolsystem.service.CourseService;
import ir.schoolsystem.service.ExamService;
import ir.schoolsystem.service.StudentService;
import ir.schoolsystem.service.TeacherService;
import ir.schoolsystem.service.impl.CourseServiceImpl;
import ir.schoolsystem.service.impl.ExamServiceImpl;
import ir.schoolsystem.service.impl.StudentServiceImpl;
import ir.schoolsystem.service.impl.TeacherServiceImpl;
import lombok.Getter;


public class ApplicationContext {


    private static final CourseRepository courseRepository;
    @Getter
    private static final CourseService courseService;
    private static final ExamRepository examRepository;
    @Getter
    private static final ExamService examService;
    private static final StudentRepository studentRepository;
    @Getter
    private static final StudentService studentService;
    private static final TeacherRepository teacherRepository;
    @Getter
    private static final TeacherService teacherService;

    static {
        courseRepository = new CourseRepositoryImpl();
        courseService = new CourseServiceImpl(courseRepository);
        examRepository = new ExamRepositoryImpl();
        examService = new ExamServiceImpl(examRepository);
        studentRepository = new StudentRepositoryImpl();
        studentService = new StudentServiceImpl(studentRepository);
        teacherRepository = new TeacherRepositoryImpl();
        teacherService = new TeacherServiceImpl(teacherRepository);
    }



}
