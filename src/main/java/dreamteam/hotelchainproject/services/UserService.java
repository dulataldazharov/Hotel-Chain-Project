package dreamteam.hotelchainproject.services;

import dreamteam.hotelchainproject.dto.UserDto;

public interface UserService {
    UserDto getUserInfo(String username);
}
