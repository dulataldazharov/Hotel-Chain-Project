package dreamteam.hotelchainproject.services;

import dreamteam.hotelchainproject.dto.Search.SearchRequestDto;
import dreamteam.hotelchainproject.dto.Search.SearchResultDto;

import java.util.List;

public interface SearchService {
    List<SearchResultDto> searchRooms(SearchRequestDto requestDto);
}
