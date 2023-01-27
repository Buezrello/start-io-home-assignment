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

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;

    @GetMapping("/listings")
    public ResponseEntity<Page<ListingDetails>> getListingDetails(Pageable pageable,
                                                                  @RequestParam(value = "min_price") Float minPrice,
                                                                  @RequestParam(value = "max_price") Float maxPrice,
                                                                  @RequestParam(value = "min_min_cpm") Float minMinCpm,
                                                                  @RequestParam(value = "max_min_cpm") Float maxMinCpm) {
        return new ResponseEntity<>(listingService.getListingDetails(pageable, minPrice, maxPrice, minMinCpm, maxMinCpm), HttpStatus.OK);
    }
}
