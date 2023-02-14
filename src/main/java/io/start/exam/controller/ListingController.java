package io.start.exam.controller;

import io.start.exam.dto.ListingDetails;
import io.start.exam.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;
    private static final float FLOAT_MAX_VALUE = Float.MAX_VALUE;

    @GetMapping("/listings")
    public ResponseEntity<Page<ListingDetails>> getListingDetails(Pageable pageable,
                                                                  @RequestParam(value = "min_price", defaultValue = "0") Float minPrice,
                                                                  @RequestParam(value = "max_price", defaultValue = FLOAT_MAX_VALUE + "") Float maxPrice,
                                                                  @RequestParam(value = "min_min_cpm", defaultValue = "0") Float minMinCpm,
                                                                  @RequestParam(value = "max_min_cpm", defaultValue = FLOAT_MAX_VALUE + "") Float maxMinCpm) {
        return new ResponseEntity<>(listingService.getListingDetails(pageable, minPrice, maxPrice, minMinCpm, maxMinCpm), HttpStatus.OK);
    }
}
