package dreamteam.hotelchainproject.dto.season;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude
public class SeasonDto {
    String name;
    Date minDate;
    Date maxDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }
}
