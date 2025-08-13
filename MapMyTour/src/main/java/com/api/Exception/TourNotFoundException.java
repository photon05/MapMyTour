package com.api.Exception;

public class TourNotFoundException extends RuntimeException {
    public TourNotFoundException(Long id) {
        super("Tour with id %d not found".formatted(id));
    }
}