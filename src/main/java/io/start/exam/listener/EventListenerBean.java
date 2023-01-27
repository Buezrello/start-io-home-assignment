package io.start.exam.listener;

import com.opencsv.bean.CsvToBeanBuilder;
import io.start.exam.dao.RedisGeneric;
import io.start.exam.dto.ListingDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventListenerBean {

    private final RedisGeneric redisGeneric;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws FileNotFoundException {

        log.info("Reading listing-details.csv from resources");

        File file = ResourceUtils.getFile("classpath:listing-details.csv");

        List<ListingDetails> listingDetailsList = new CsvToBeanBuilder<ListingDetails>(new FileReader(file))
                .withType(ListingDetails.class)
                .build()
                .parse();

        redisGeneric.cleanAllListingDetails();
        redisGeneric.saveAllListingDetails(listingDetailsList);
    }
}
