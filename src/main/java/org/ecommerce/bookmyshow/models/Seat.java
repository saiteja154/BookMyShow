package org.ecommerce.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
    private String number;

    @ManyToOne
    private SeatType seatType;

    private int rowVal;
    private int colVal;
}
