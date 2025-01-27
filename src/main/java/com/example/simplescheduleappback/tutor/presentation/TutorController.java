package com.example.simplescheduleappback.tutor.presentation;

import com.example.simplescheduleappback.tutor.application.TutorService;
import com.example.simplescheduleappback.tutor.presentation.dto.request.CreateTutorRequest;
import com.example.simplescheduleappback.tutor.presentation.dto.request.UpdateTutorRequest;
import com.example.simplescheduleappback.tutor.presentation.dto.response.ReadTutorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @PostMapping("/tutors")
    public ResponseEntity<Void> createTutor(@RequestBody CreateTutorRequest createTutorRequest) {
        log.info("method: createTutor, requested username: {}", createTutorRequest.username());
        Long createdTutorId = tutorService.registerTutor(createTutorRequest);
        return ResponseEntity.created(URI.create("/tutors/" + createdTutorId)).build();
    }

    @GetMapping("/tutors/{tutorId}")
    public ResponseEntity<ReadTutorResponse> readTutor(@PathVariable Long tutorId) {
        log.info("method: readTutor, requested id: {}", tutorId);
        ReadTutorResponse readTutorResponse = tutorService.showTutor(tutorId);
        return ResponseEntity.ok(readTutorResponse);
    }

    @PutMapping("/tutors/{tutorId}")
    public ResponseEntity<Void> updateTutor(@PathVariable Long tutorId, @RequestBody UpdateTutorRequest updateTutorRequest) {
        log.info("method: updateTutor, requested id: {}", tutorId);
        tutorService.modifyTutor(tutorId, updateTutorRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tutors/{tutorId}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long tutorId) {
        log.info("method: deleteTutor, requested id: {}", tutorId);
        tutorService.removeTutor(tutorId);
        return ResponseEntity.ok().build();
    }
}
