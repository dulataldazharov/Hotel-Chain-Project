package dreamteam.hotelchainproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class UserDto {
    Long id;
    String username;
    String address;

    public UserDto() {
    }

    public UserDto(Long id, String username, String address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
