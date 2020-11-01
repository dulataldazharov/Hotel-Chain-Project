package dreamteam.hotelchainproject.models;

import javax.persistence.*;

@Entity
@IdClass(RoomPK.class)
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_number")
    private int roomNumber;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "floor")
    private int floor;

    @Column(name = "is_clean")
    private String isClean;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getIsClean() {
        return isClean;
    }

    public void setIsClean(String isClean) {
        this.isClean = isClean;
    }

}
