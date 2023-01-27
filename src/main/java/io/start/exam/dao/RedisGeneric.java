package io.start.exam.dao;

import io.start.exam.dto.ListingDetails;

import java.util.List;

public interface RedisGeneric {

    List<ListingDetails> getAllListingDetails();
    void saveAllListingDetails(List<ListingDetails> listingDetailsList);
    void cleanAllListingDetails();
}
