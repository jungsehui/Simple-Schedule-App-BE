package com.example.simplescheduleappback.student.domain.entity;

import com.example.simplescheduleappback.lecture.domain.entity.Lecture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @Builder
    public Student(
            final String name,
            final String phoneNumber,
            final Lecture lecture
    ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.lecture = lecture;
    }
}
