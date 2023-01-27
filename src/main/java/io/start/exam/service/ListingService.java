package io.start.exam.service;

import io.start.exam.dto.ListingDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ListingService {

    Page<ListingDetails> getListingDetails(Pageable pageable, Float minPrice, Float maxPrice, Float minMinCpm, Float maxMinCpm);
}
