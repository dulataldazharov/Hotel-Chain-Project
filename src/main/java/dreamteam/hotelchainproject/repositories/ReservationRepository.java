package dreamteam.hotelchainproject.repositories;

import dreamteam.hotelchainproject.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    List<Reservation> findAllByGuestEmail(String guestEmail);
    Long removeByReservationId(int id);

}
