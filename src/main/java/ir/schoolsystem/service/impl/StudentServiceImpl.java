package ir.schoolsystem.service.impl;

import ir.schoolsystem.model.Student;
import ir.schoolsystem.repository.StudentRepository;
import ir.schoolsystem.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository sr;

    public StudentServiceImpl(StudentRepository sr) {
        this.sr = sr;
    }

    @Override
    public void save(Student student) {
        if (student != null) {
            sr.save(student);
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            sr.delete(id);
        }
    }

    @Override
    public void update(Student student) {
        if (student != null) {
            sr.update(student);
        }
    }

    @Override
    public void printAll() {
        try {
            List<Student> students = sr.findAll().get();
            while (true) {
                System.out.format("\033[1;35m"+"+------+----------------+---------------+----------------+----------+%n");
                System.out.format("\033[1;35m"+"| ID   | first name     | last name     | national code   |  Score  |%n");
                System.out.format("\033[1;35m"+"+------+----------------+---------------+-----------------+---------+%n");
                for (Student student : students) {
                    System.out.printf("\033[1;35m" + "|" + "\033[1;34m" + " %-4s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-14s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-13s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-13s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-10s" + "\033[1;35m" + "|" + "\n",
                            student.getId(),
                            student.getFirstName(),
                            student.getLastName(),
                            student.getNationalCode(),
                            student.getScore());

                }

                System.out.format("\033[1;35m" + "+------+----------------+---------------+-----------------+---------+%n");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }
}
