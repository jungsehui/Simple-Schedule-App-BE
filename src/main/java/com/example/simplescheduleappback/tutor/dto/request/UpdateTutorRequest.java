package com.example.simplescheduleappback.tutor.dto.request;

public record UpdateTutorRequest(

        String name,
        String phoneNumber,
        String username,
        String password
) {
}
