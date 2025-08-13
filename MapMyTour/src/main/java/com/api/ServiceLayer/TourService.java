package com.api.ServiceLayer;


import com.api.Exception.TourNotFoundException;
import com.api.mapmytour.Dto.TourRequest;
import com.api.mapmytour.Dto.TourResponse;
import com.api.mapmytour.Entity.Tour;
import com.api.mapmytour.Repository.TourRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    private final TourRepo repository;

    public TourService(TourRepo repository) {
        this.repository = repository;
    }

    public TourResponse create(TourRequest request) {
        Tour tour = Tour.builder()
                .image(request.getImage())
                .discountInPercentage(request.getDiscountInPercentage())
                .title(request.getTitle())
                .description(request.getDescription())
                .duration(request.getDuration())
                .actualPrice(request.getActualPrice())
                .discountedPrice(request.getDiscountedPrice())
                .build();
        Tour saved = repository.save(tour);
        return toResponse(saved);
    }

    public List<TourResponse> findAll() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    public TourResponse findById(Long id) {
        Tour tour = repository.findById(id)
                .orElseThrow(() -> new TourNotFoundException(id));
        return toResponse(tour);
    }

    private TourResponse toResponse(Tour t) {
        return new TourResponse(
                t.getId(),
                t.getImage(),
                t.getDiscountInPercentage(),
                t.getTitle(),
                t.getDescription(),
                t.getDuration(),
                t.getActualPrice(),
                t.getDiscountedPrice()
        );
    }
}