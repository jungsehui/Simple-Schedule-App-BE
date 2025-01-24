package com.example.simplescheduleappback.tutor.application;

import com.example.simplescheduleappback.tutor.domain.entity.Tutor;
import com.example.simplescheduleappback.tutor.domain.repository.TutorRepository;
import com.example.simplescheduleappback.tutor.dto.request.CreateTutorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    public Long registerTutor(CreateTutorRequest createTutorRequest) {
        Tutor tutor = Tutor.builder()
                .name(createTutorRequest.name())
                .phoneNumber(createTutorRequest.phoneNumber())
                .username(createTutorRequest.username())
                .password(createTutorRequest.password())
                .build();

        return tutorRepository.save(tutor).getTutorId();
    }
}
