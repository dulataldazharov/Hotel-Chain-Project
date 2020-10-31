package dreamteam.hotelchainproject.models;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "type")
    private String type;

    @Column(name = "hotel_id")
    private int hotelId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

}
