package ir.schoolsystem.service.impl;

import ir.schoolsystem.model.Exam;
import ir.schoolsystem.repository.ExamRepository;
import ir.schoolsystem.service.ExamService;

import java.sql.SQLException;
import java.util.List;

public class ExamServiceImpl implements ExamService {

    private ExamRepository er;

    public ExamServiceImpl(ExamRepository er) {
        this.er = er;
    }

    @Override
    public void save(Exam exam) {
        if (exam != null) {
            er.save(exam);
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            er.delete(id);
        }
    }

    @Override
    public void update(Exam exam) {
        if (exam != null) {
            er.update(exam);
        }
    }

    @Override
    public void printAll() {
        try {
            List<Exam> exams = er.findAll().get();
            System.out.format("\033[1;35m" + "+------+----------------+-------------+------------+-----------+%n");
            System.out.format("\033[1;35m" + "| ID   | Exam name      | Exam Date   | Exam Time  | Course ID |%n");
            System.out.format("\033[1;35m" + "+------+----------------+-------------+------------+-----------+%n");
            for (Exam exam : exams) {
                System.out.printf("\033[1;35m" + "|" + "\033[1;34m" + " %-4s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-14s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-11s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-11s" + "\033[1;35m" + "|" +"\033[1;34m" + " %-10s" + "\033[1;35m" + "|" + "\n",
                        exam.getId(),
                        exam.getExamtitle(),
                        exam.getExamDate(),
                        exam.getExamTime(),
                        exam.getCourse().getId());
            }
            System.out.format("\033[1;35m" + "+------+----------------+-------------+------------+-----------+%n");
        } catch (Exception e) {
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }
}
