package ir.schoolsystem.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "students")
public class Student extends BaseModel {


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_code", unique = true)
    private String nationalCode;

    @Column(name = "score")
    private Double score;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "j_student_course",
            joinColumns = {@JoinColumn(name = "fk_student_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_course_id")}
    )
   private List<Course> courses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "j_student_exam",
            joinColumns = {@JoinColumn(name = "fk_student_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_exam_id")}
    )
    private List<Exam> exams = new ArrayList<>();


}
