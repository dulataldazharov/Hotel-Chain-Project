package dreamteam.hotelchainproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class UserDto {

    String username;
    String address;

    public UserDto() {
    }

    public UserDto(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
