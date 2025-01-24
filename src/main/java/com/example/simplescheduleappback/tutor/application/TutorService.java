package com.example.simplescheduleappback.tutor.application;

import com.example.simplescheduleappback.tutor.domain.entity.Tutor;
import com.example.simplescheduleappback.tutor.domain.repository.TutorRepository;
import com.example.simplescheduleappback.tutor.dto.request.CreateTutorRequest;
import com.example.simplescheduleappback.tutor.dto.request.UpdateTutorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    @Transactional
    public Long registerTutor(CreateTutorRequest createTutorRequest) {
        Tutor tutor = Tutor.builder()
                .name(createTutorRequest.name())
                .phoneNumber(createTutorRequest.phoneNumber())
                .username(createTutorRequest.username())
                .password(createTutorRequest.password())
                .build();

        return tutorRepository.save(tutor).getTutorId();
    }

    @Transactional
    public Long modifyTutor(Long tutorId, UpdateTutorRequest updateTutorRequest) {
        Tutor tutor = tutorRepository.findByTutorId(tutorId)
                .orElseThrow();

        tutor.modifyTutor(
                updateTutorRequest.name(),
                updateTutorRequest.phoneNumber(),
                updateTutorRequest.username(),
                updateTutorRequest.password()
        );

        return tutorRepository.save(tutor).getTutorId();
    }
}
