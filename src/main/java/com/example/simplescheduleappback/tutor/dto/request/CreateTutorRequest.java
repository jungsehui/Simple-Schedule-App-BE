package com.example.simplescheduleappback.tutor.dto.request;

public record CreateTutorRequest(

        String name,
        String phoneNumber,
        String username,
        String password
) {
}
