package dreamteam.hotelchainproject.repositories;

import dreamteam.hotelchainproject.models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
    RoomType getByRoomTypeId(int roomTypeId);
public interface RoomTypeRepository extends JpaRepository<RoomType,Integer> {
    RoomType findByRoomTypeId(Integer id);
}
