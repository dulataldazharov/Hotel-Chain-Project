package dreamteam.hotelchainproject.servicesImpl;

import dreamteam.hotelchainproject.dto.UserDto;
import dreamteam.hotelchainproject.models.User;
import dreamteam.hotelchainproject.repositories.UserRepository;
import dreamteam.hotelchainproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto getUserInfo(String username) {
        User user = userRepository.findByUsername(username).get();
        return mapUserToDto(user);
    }


    private UserDto mapUserToDto(User user){
        return new UserDto(user.getUsername(), user.getAddress());
    }
}
