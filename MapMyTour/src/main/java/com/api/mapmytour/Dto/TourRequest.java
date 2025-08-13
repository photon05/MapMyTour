package com.api.mapmytour.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TourRequest {

    @NotBlank(message = "image is required")
    private String image;

    @NotBlank(message = "discountInPercentage is required")
    private String discountInPercentage;

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "duration is required")
    private String duration;

    @NotBlank(message = "actualPrice is required")
    private String actualPrice;

    @NotBlank(message = "discountedPrice is required")
    private String discountedPrice;
}
