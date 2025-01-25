package com.example.simplescheduleappback.tutor.presentation;

import com.example.simplescheduleappback.tutor.application.TutorService;
import com.example.simplescheduleappback.tutor.dto.request.CreateTutorRequest;
import com.example.simplescheduleappback.tutor.dto.response.ReadTutorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @PostMapping("/tutors")
    public ResponseEntity<Void> createTutor(@RequestBody CreateTutorRequest createTutorRequest) {
        Long tutorId = tutorService.registerTutor(createTutorRequest);
        return ResponseEntity.created(URI.create("/tutors/" + tutorId)).build();
    }

    @GetMapping("/tutors/{tutorId}")
    public ResponseEntity<ReadTutorResponse> readTutor(@PathVariable Long tutorId) {
        ReadTutorResponse readTutorResponse = tutorService.showTutor(tutorId);
        return ResponseEntity.ok(readTutorResponse);
    }
}
