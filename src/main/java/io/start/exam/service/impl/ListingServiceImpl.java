package io.start.exam.service.impl;

import io.start.exam.dao.RedisGeneric;
import io.start.exam.dto.ListingDetails;
import io.start.exam.exception.ListingDetailsException;
import io.start.exam.service.ListingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ListingServiceImpl implements ListingService {

    private final RedisGeneric redisGeneric;

    @Override
    public Page<ListingDetails> getListingDetails(Pageable pageable, Float minPrice, Float maxPrice, Float minMinCpm, Float maxMinCpm) {

        List<ListingDetails> allListingDetails = redisGeneric.getAllListingDetails();

        log.info("Filter response by minPrice {}, maxPrice {}, minMinCpm {}, maxMinCpm {}", minPrice, maxPrice, minMinCpm, maxMinCpm);

        List<ListingDetails> listingDetails = allListingDetails.stream()
                .filter(e -> e.getPrice() >= minPrice)
                .filter(e -> e.getPrice() <= maxPrice)
                .filter(e -> e.getMinCpm() >= minMinCpm)
                .filter(e -> e.getMinCpm() <= maxMinCpm)
                .collect(Collectors.toList());

        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), listingDetails.size());

        if (start >= end) {
            log.error("page number {} not found", pageable.getPageNumber());
            throw new ListingDetailsException(String.format("Page number %d with size %d not found", pageable.getPageNumber(), pageable.getPageSize()));
        }

        return new PageImpl<>(listingDetails.subList(start, end), pageable, listingDetails.size());
    }
}
