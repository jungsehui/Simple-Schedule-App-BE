package com.example.simplescheduleappback.tutor.presentation.dto.request;

public record UpdateTutorRequest(

        String name,
        String phoneNumber,
        String username,
        String password
) {
}
