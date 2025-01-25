package com.example.simplescheduleappback.student.domain.entity;

import com.example.simplescheduleappback.lecture.domain.entity.Lecture;
import com.example.simplescheduleappback.lecture.domain.entity.LectureStudent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureStudent> lectureStudents;

    @Builder
    public Student(
            final String name,
            final String phoneNumber
    ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
