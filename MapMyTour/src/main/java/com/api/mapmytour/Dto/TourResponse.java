package com.api.mapmytour.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TourResponse {
    private Long id;
    private String image;
    private String discountInPercentage;
    private String title;
    private String description;
    private String duration;
    private String actualPrice;
    private String discountedPrice;
}
