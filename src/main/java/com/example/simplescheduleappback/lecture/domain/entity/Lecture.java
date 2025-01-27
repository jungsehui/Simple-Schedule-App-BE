package com.example.simplescheduleappback.lecture.domain.entity;

import com.example.simplescheduleappback.student.domain.entity.Student;
import com.example.simplescheduleappback.tutor.domain.entity.Tutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lecture")
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long lectureId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "memo")
    private String memo;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LectureStudent> lectureStudents;

    @Builder
    public Lecture(
            final String name,
            final LocalDateTime startTime,
            final LocalDateTime endTime,
            final String memo,
            final Tutor tutor
    ) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.memo = memo;
        this.tutor = tutor;
    }
}
