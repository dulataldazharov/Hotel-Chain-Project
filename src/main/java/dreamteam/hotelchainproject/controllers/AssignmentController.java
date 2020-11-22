package dreamteam.hotelchainproject.controllers;

import dreamteam.hotelchainproject.dto.booking.RoomDto;
import dreamteam.hotelchainproject.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @GetMapping("/available-rooms")
    List<RoomDto> getAvailableRooms(@RequestParam(required = true) int reservationId){
        return assignmentService.availableRooms(reservationId);
    }

    @GetMapping("/assigned-rooms")
    List<RoomDto> getAssignedRooms(@RequestParam(required = true) int reservationId){
        return assignmentService.assignedRooms(reservationId);
    }

    @PostMapping("/create-assignment")
    void createAssignment(@RequestParam(required = true) int reservationId, @RequestParam(required = true) int roomNumber){
        assignmentService.createAssignment(reservationId, roomNumber);
    }

    @DeleteMapping("/delete-assignment")
    void deleteAssignment(@RequestParam(required = true) int reservationId, @RequestParam(required = true) int roomNumber){
        assignmentService.deleteAssignment(reservationId, roomNumber);
    }

}
