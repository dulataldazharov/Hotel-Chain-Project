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
    public UserDto getUserInfo(Long id) {
        User user = userRepository.findUserById(id);
        return mapUserToDto(user);
    }


    private UserDto mapUserToDto(User user){
        return new UserDto(user.getId(), user.getUsername(), user.getAddress());
    }
}
