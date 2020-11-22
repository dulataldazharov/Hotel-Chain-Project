package dreamteam.hotelchainproject.dto.season;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class NewPriceDto {
    int roomTypeId;
    int value;

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
