package dreamteam.hotelchainproject.services;

import dreamteam.hotelchainproject.dto.Search.SearchRequestDto;
import dreamteam.hotelchainproject.dto.Search.SearchResultDto;
import dreamteam.hotelchainproject.models.Room;

import java.util.Date;
import java.util.List;

public interface SearchService {
    List<SearchResultDto> searchRooms(SearchRequestDto requestDto);
    Integer calculatePrice(Room room, Date dateMin, Date dateMax);
}
