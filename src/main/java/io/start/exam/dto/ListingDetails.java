package io.start.exam.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("ListingDetails")
public class ListingDetails {

    @Id
    @JsonIgnore
    @CsvBindByName(column = "session_id")
    private Long sessionId;

    @CsvBindByName(column = "advertiser_id")
    Long advertiserId;

    @CsvBindByName(column = "country")
    String country;

    @CsvBindByName(column = "price")
    Float price;

    @CsvBindByName(column = "event_type_id")
    Integer eventTypeId;

    @CsvBindByName(column = "gdpr")
    Integer gdpr;

    @CsvBindByName(column = "min_cpm")
    Float minCpm;

    @CsvBindByName(column = "priority")
    Float priority;

    @CsvBindByName(column = "bid_price")
    Float bidPrice;
}
