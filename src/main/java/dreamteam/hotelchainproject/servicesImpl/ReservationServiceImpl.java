package dreamteam.hotelchainproject.servicesImpl;

import dreamteam.hotelchainproject.dto.booking.RoomBookingDto;
import dreamteam.hotelchainproject.dto.profile.ReservationDto;
import dreamteam.hotelchainproject.models.Reservation;
import dreamteam.hotelchainproject.models.RoomAssignment;
import dreamteam.hotelchainproject.repositories.ReservationRepository;
import dreamteam.hotelchainproject.repositories.RoomAssignmentRepository;
import dreamteam.hotelchainproject.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    private RoomAssignmentRepository roomAssignmentRepository;

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
    public Long cancelReservation(int id) {
        Long delCnt = reservationRepository.deleteByReservationId(id);
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

    @Override
    public Reservation bookRoom(RoomBookingDto data, String user) {
        Reservation reservation = reservationRepository.saveAndFlush(mapDtoToReservation(data, user));
        RoomAssignment roomAssignment = roomAssignmentRepository.save(mapDtoToRoomAssignment(data, reservation, user));
        return reservation;
    }
    Reservation mapDtoToReservation(RoomBookingDto data, String user) {
        Reservation entity = new Reservation();
        entity.setFinalPrice(data.getPrice());
        entity.setGuestEmail(user);
        entity.setRoomCount(data.getRoomCount());
        entity.setRoomTypeId(data.getRoomTypeId());
        entity.setCheckInDate(data.getCheckIn());
        entity.setCheckOutDate(data.getCheckOut());
        return entity;
    }
    RoomAssignment mapDtoToRoomAssignment(RoomBookingDto data, Reservation reservation, String user) {
        RoomAssignment roomAssignment = new RoomAssignment();
        roomAssignment.setGuestEmail(user);
        roomAssignment.setHotelId(data.getHotelId());
        roomAssignment.setRoomNumber(data.getRoomNumber());
        roomAssignment.setReservationId(reservation.getReservationId());
        return roomAssignment;
    }
}
