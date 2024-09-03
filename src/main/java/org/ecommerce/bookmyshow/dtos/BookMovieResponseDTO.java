package org.ecommerce.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;
import org.ecommerce.bookmyshow.models.Booking;
import org.ecommerce.bookmyshow.models.BookingStatus;

@Getter
@Setter
public class BookMovieResponseDTO {
    private Booking booking;

    private ResponseStatus responseStatus;

}
