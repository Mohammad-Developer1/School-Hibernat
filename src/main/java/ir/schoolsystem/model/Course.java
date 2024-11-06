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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(name = "courses")
public class Course extends BaseModel {

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "course_unit")
    private Integer courseUnit;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();


}
