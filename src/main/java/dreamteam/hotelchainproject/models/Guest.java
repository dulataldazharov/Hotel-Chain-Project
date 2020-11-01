package dreamteam.hotelchainproject.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "guest")
public class Guest extends User {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "category")
    private String category;

    @Column(name = "discount_value")
    private int discountValue;

    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }

}
