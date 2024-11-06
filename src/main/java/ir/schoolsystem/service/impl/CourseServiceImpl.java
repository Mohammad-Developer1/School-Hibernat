package ir.schoolsystem.service.impl;

import ir.schoolsystem.model.Course;
import ir.schoolsystem.repository.CourseRepository;
import ir.schoolsystem.service.CourseService;

import java.sql.SQLException;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseRepository cr;

    public CourseServiceImpl(CourseRepository cr) {
        this.cr = cr;
    }

    @Override
    public void save(Course course) {
        if (course != null) {
            cr.save(course);
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            cr.delete(id);
        }
    }

    @Override
    public void update(Course course) {
        if (course != null) {
            cr.update(course);
        }
    }

    @Override
    public void printAll() {
        try {
            List<Course> courses = cr.findAll().get();
            System.out.format("\033[1;35m" + "+------+-----------+------+%n");
            System.out.format("\033[1;35m" + "| ID   | Title     | unit |%n");
            System.out.format("\033[1;35m" + "+------+-----------+------+%n");
            for (Course course : courses) {
                System.out.printf("\033[1;35m" + "|" + "\033[1;34m" + " %-4s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-9s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-4s" + "\033[1;35m" + " |" + "\033[1;34m" + "\n",
                        course.getId(),
                        course.getCourseTitle(),
                        course.getCourseUnit());
            }
            System.out.format("\033[1;35m" + "+------+-----------+------+%n");
        } catch (Exception e) {
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }
}



