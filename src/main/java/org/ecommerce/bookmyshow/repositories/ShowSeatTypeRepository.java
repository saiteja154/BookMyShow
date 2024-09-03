package org.ecommerce.bookmyshow.repositories;

import org.ecommerce.bookmyshow.models.SeatType;
import org.ecommerce.bookmyshow.models.Show;
import org.ecommerce.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Show show);

    Optional<ShowSeatType> findBySeatType(SeatType seatType);

}
