package com.api.mapmytour.Repository;

import com.api.mapmytour.Entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepo extends JpaRepository<Tour, Long> { }