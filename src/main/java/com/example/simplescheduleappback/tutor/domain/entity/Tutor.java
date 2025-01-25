package com.example.simplescheduleappback.tutor.domain.entity;

import com.example.simplescheduleappback.lecture.domain.entity.Lecture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tutor")
@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutor_id", nullable = false, updatable = false)
    private Long tutorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lecture> lectures;

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
