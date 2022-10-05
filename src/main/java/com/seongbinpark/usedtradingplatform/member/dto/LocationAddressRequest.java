package com.seongbinpark.usedtradingplatform.member.dto;

import com.seongbinpark.usedtradingplatform.member.domain.entity.Address;
import com.seongbinpark.usedtradingplatform.member.domain.entity.Location;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class LocationAddressRequest {

    private final String state;
    private final String city;
    private final String town;

    private Double longitude;
    private Double latitude;

    public Address toAddress() {
        return Address.builder()
                .state(state)
                .city(city)
                .town(town)
                .build();
    }

    public Location toLocation() {
        return Location.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }




}
