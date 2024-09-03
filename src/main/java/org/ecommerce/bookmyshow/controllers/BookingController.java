package org.ecommerce.bookmyshow.controllers;

import org.ecommerce.bookmyshow.dtos.BookMovieResponseDTO;
import org.ecommerce.bookmyshow.dtos.BookingMovieRequestDto;
import org.ecommerce.bookmyshow.dtos.ResponseStatus;
import org.ecommerce.bookmyshow.models.Booking;
import org.ecommerce.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {


    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService=bookingService;
    }

    public BookMovieResponseDTO bookMovie(BookingMovieRequestDto bookingMovieRequestDto){
        BookMovieResponseDTO bookMovieResponseDTO=new BookMovieResponseDTO();

        try {
            Booking booking = bookingService.bookMovie(
                    bookingMovieRequestDto.getUserId(),
                    bookingMovieRequestDto.getShowId(),
                    bookingMovieRequestDto.getShowSeatsId()
            );
            bookMovieResponseDTO.setBooking(booking);
            bookMovieResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return bookMovieResponseDTO;
        }
        catch (Exception ex){
            bookMovieResponseDTO.setResponseStatus(ResponseStatus.FAILED);
            return bookMovieResponseDTO;
        }


    }

}
