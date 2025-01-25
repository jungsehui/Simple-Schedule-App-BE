package com.example.simplescheduleappback.lecture.domain.entity;

import com.example.simplescheduleappback.student.domain.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lecture_student")
@Entity
public class LectureStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_student_id")
    private Long lectureStudentId;

    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Builder
    public LectureStudent(
            final Student student,
            final Lecture lecture
    ) {
        this.student = student;
        this.lecture = lecture;
    }
}
