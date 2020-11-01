package dreamteam.hotelchainproject.models;

import javax.persistence.*;

@Entity
@IdClass(HotelFeaturePK.class)
@Table(name = "hotel_feature")
public class HotelFeature {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Id
    @Column(name = "feature")
    private String feature;

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
