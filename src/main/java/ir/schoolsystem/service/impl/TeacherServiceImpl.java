package ir.schoolsystem.service.impl;

import ir.schoolsystem.model.Teacher;
import ir.schoolsystem.repository.TeacherRepository;
import ir.schoolsystem.service.TeacherService;

import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository tr;

    public TeacherServiceImpl(TeacherRepository tr) {
        this.tr = tr;
    }

    @Override
    public void save(Teacher teacher) {
        if (teacher != null) {
            tr.save(teacher);
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            tr.delete(id);
        }
    }

    @Override
    public void update(Teacher teacher) {
        if (teacher != null) {
            tr.update(teacher);

        }
    }

    @Override
    public void printAll() {
        try {
            List<Teacher> teachers = tr.findAll().get();
            System.out.format("\033[1;35m"+"+------+----------------+---------------+---------------+-----------+%n");
            System.out.format("\033[1;35m"+"| ID   | first name     | last name     | national code | Course Id |%n");
            System.out.format("\033[1;35m"+"+------+----------------+---------------+---------------+-----------+%n");
            for (Teacher teacher : teachers) {
                System.out.printf("\033[1;35m"+"|"+"\033[1;34m"+" %-4s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-14s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-13s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-14s"+"\033[1;35m"+"|"+"\033[1;34m"+" %-10s"+"\033[1;35m"+"|"+"\n",
                        teacher.getId(),
                        teacher.getFirstName(),
                        teacher.getLastName(),
                        teacher.getNationalCode(),
                        teacher.getCourse().getId());
            }
            System.out.format("\033[1;35m"+"+------+----------------+---------------+---------------+-----------+%n");
        } catch (Exception e) {
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }
}
