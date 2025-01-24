package com.example.simplescheduleappback.tutor.domain.entity;

import com.example.simplescheduleappback.lecture.domain.entity.Lecture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tutor")
@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutor_id")
    private Long tutorId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;

    @Builder
    private Tutor(
            final String name,
            final String phoneNumber,
            final String username,
            final String password
    ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    public void modifyTutor(
            final String name,
            final String phoneNumber,
            final String username,
            final String password
    ) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }
}
