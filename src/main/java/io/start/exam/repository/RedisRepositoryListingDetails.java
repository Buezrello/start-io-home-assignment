package io.start.exam.repository;

import io.start.exam.dto.ListingDetails;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepositoryListingDetails extends CrudRepository<ListingDetails, Integer> { }
