package dreamteam.hotelchainproject;

import dreamteam.hotelchainproject.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class HotelchainprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelchainprojectApplication.class, args);
    }

}
