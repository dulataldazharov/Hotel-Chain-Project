package dreamteam.hotelchainproject.controllers;

import dreamteam.hotelchainproject.dto.GeneralDto;
import dreamteam.hotelchainproject.dto.profile.ReservationDto;
import dreamteam.hotelchainproject.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ReservationService reservationService;

    @GetMapping("/reservation/profile/past")
    List<ReservationDto> getUserProfileReservationsPast(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return reservationService.getUserProfileReservationsPast(username);
    }

    @GetMapping("/reservation/profile/active")
    List<ReservationDto> getUserProfileReservationsActive(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return reservationService.getUserProfileReservationsActive(username);
    }

    @GetMapping("/reservation/profile/future")
    List<ReservationDto> getUserProfileReservationsFuture(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return reservationService.getUserProfileReservationsFuture(username);
    }

    @DeleteMapping("/reservation/{id}/cancel")
    GeneralDto cancelReservation(@PathVariable int id){
        Long delCnt = reservationService.cancelReservation(id);
        if (delCnt==0)
            return new GeneralDto("Nothing got deleted", false);
        else
            return new GeneralDto(delCnt+" item(s) were deleted", true);
    }

}
