package io.start.exam.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class ListingDetailsException  extends RuntimeException{

    public ListingDetailsException(String message) {
        super(message);
    }

    public ListingDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}
