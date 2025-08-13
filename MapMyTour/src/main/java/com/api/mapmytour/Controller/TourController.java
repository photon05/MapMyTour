package com.api.mapmytour.Controller;


import com.api.Exception.TourNotFoundException;
import com.api.mapmytour.Dto.TourRequest;
import com.api.mapmytour.Dto.TourResponse;
import com.api.mapmytour.Entity.Tour;
import com.api.mapmytour.Repository.TourRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    private final TourRepo tourRepo;

    public TourController(TourRepo tourRepo) {
        this.tourRepo = tourRepo;
    }

    @PostMapping
    public ResponseEntity<TourResponse> createTour(@Valid @RequestBody TourRequest request) {
        Tour tour = new Tour(
                null,
                request.getImage(),
                request.getDiscountInPercentage(),
                request.getTitle(),
                request.getDescription(),
                request.getDuration(),
                request.getActualPrice(),
                request.getDiscountedPrice()
        );
        Tour savedTour = tourRepo.save(tour);
        return new ResponseEntity<>(mapToResponse(savedTour), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TourResponse>> getAllTours() {
        List<TourResponse> tours = tourRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourResponse> getTourById(@PathVariable Long id) {
        Tour tour = tourRepo.findById(id)
                .orElseThrow(() -> new TourNotFoundException(id));
        return ResponseEntity.ok(mapToResponse(tour));
    }

    private TourResponse mapToResponse(Tour tour) {
        return new TourResponse(
                tour.getId(),
                tour.getImage(),
                tour.getDiscountInPercentage(),
                tour.getTitle(),
                tour.getDescription(),
                tour.getDuration(),
                tour.getActualPrice(),
                tour.getDiscountedPrice()
        );
    }
}
