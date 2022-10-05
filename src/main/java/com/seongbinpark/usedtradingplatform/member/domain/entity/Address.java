package com.seongbinpark.usedtradingplatform.member.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Builder
@Getter
@RequiredArgsConstructor
@Embeddable
@AllArgsConstructor
public class Address {

    private String state;
    private String city;
    private String town;

}
