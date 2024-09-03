package org.ecommerce.bookmyshow.services;

import org.ecommerce.bookmyshow.models.SeatType;
import org.ecommerce.bookmyshow.models.Show;
import org.ecommerce.bookmyshow.models.ShowSeat;
import org.ecommerce.bookmyshow.models.ShowSeatType;
import org.ecommerce.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class PriceCalculationService {

    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(List<ShowSeat> showSeats, Show show) {
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);


        int totalAmount = 0;

        for(ShowSeat showSeat : showSeats){
            /*
            price of the current show seat
             */
            SeatType seatType = showSeat.getSeat().getSeatType();
            /*  Database call every time...
            //Optional<ShowSeatType> showSeat1 = showSeatTypeRepository.findBySeatType(seatType);
            // show, seattype, price
            //totalAmount += showSeat1.get().getPrice();

             */
            for(ShowSeatType showSeatType:showSeatTypes) {
                if (showSeatType.getSeatType() == seatType) {
                    totalAmount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return totalAmount;

    }
}

 /*
        Show  SeatType  price
        1       1       100
        1       2       200
        1       3       300
        1       4       250
        1       5       80
        1       6       1000

*/



/*
List<ShowSeats>
1. showid, seat id, status
2.
3.
4.
5.

 */