package dreamteam.hotelchainproject.services;

import dreamteam.hotelchainproject.dto.profile.ReservationDto;

import java.util.List;

public interface ReservationService {
    List<ReservationDto> getUserProfileReservationsPast(String username);
    List<ReservationDto> getUserProfileReservationsActive(String username);
    List<ReservationDto> getUserProfileReservationsFuture(String username);
    Long cancelReservation(int id);
}
