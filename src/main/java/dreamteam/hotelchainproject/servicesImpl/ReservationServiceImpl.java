package dreamteam.hotelchainproject.servicesImpl;

import dreamteam.hotelchainproject.dto.profile.ReservationDto;
import dreamteam.hotelchainproject.models.Reservation;
import dreamteam.hotelchainproject.repositories.ReservationRepository;
import dreamteam.hotelchainproject.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<ReservationDto> getUserProfileReservationsPast(String username) {
        List<Reservation> reservations = reservationRepository.findAllByGuestEmail(username);
        List<ReservationDto> dtos = new ArrayList<>();
        Date currentDate = new Date();
        for (Reservation reservation : reservations){
            if (reservation.getCheckOutDate().getTime()<currentDate.getTime())
                dtos.add(mapEntityToDto(reservation));
        }
        return dtos;
    }

    @Override
    public List<ReservationDto> getUserProfileReservationsActive(String username) {
        List<Reservation> reservations = reservationRepository.findAllByGuestEmail(username);
        List<ReservationDto> dtos = new ArrayList<>();
        Date currentDate = new Date();
        for (Reservation reservation : reservations){
            if (reservation.getCheckOutDate().getTime()>=currentDate.getTime()
            && reservation.getCheckInDate().getTime()<=currentDate.getTime())
                dtos.add(mapEntityToDto(reservation));
        }
        return dtos;
    }

    @Override
    public List<ReservationDto> getUserProfileReservationsFuture(String username) {
        List<Reservation> reservations = reservationRepository.findAllByGuestEmail(username);
        List<ReservationDto> dtos = new ArrayList<>();
        Date currentDate = new Date();
        for (Reservation reservation : reservations){
            if (reservation.getCheckInDate().getTime()>currentDate.getTime())
                dtos.add(mapEntityToDto(reservation));
        }
        return dtos;
    }

    @Override
    @Transactional
    public Long cancelReservation(int id) {
        Long delCnt = reservationRepository.removeByReservationId(id);
        return delCnt;
    }


    ReservationDto mapEntityToDto(Reservation reservation){
        ReservationDto dto = new ReservationDto();
        dto.setCheckInDate(reservation.getCheckInDate());
        dto.setCheckOutDate(reservation.getCheckOutDate());
        dto.setFinalPrice(reservation.getFinalPrice());
        dto.setReservationId(reservation.getReservationId());
        dto.setRoomCount(reservation.getRoomCount());
        return dto;
    }

}
