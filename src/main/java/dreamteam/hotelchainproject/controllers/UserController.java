package dreamteam.hotelchainproject.controllers;

import dreamteam.hotelchainproject.dto.UserDto;
import dreamteam.hotelchainproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/")
    public UserDto getUser(){
        String username = "dulat@mail.kz";
        return userService.getUserInfo(username);
    }
}
