package io.start.exam.dao.impl;

import io.start.exam.dao.RedisGeneric;
import io.start.exam.dto.ListingDetails;
import io.start.exam.repository.RedisRepositoryListingDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RedisGenericImpl implements RedisGeneric {

    private final RedisRepositoryListingDetails redisRepositoryListingDetails;

    @Override
    public List<ListingDetails> getAllListingDetails() {
        log.info("Fetching all Listing Details from database");
        return (List<ListingDetails>) redisRepositoryListingDetails.findAll();
    }

    @Override
    public void saveAllListingDetails(List<ListingDetails> listingDetailsList) {
        log.info("Saving a list Listing Details to database");
        redisRepositoryListingDetails.saveAll(listingDetailsList);
    }

    @Override
    public void cleanAllListingDetails() {
        log.info("Cleaning Listing Details from database");
        redisRepositoryListingDetails.deleteAll();
    }
}
