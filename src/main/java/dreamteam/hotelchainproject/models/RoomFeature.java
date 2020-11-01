package dreamteam.hotelchainproject.models;

import javax.persistence.*;

@Entity
@IdClass(RoomFeaturePK.class)
@Table(name = "room_feature")
public class RoomFeature {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

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
