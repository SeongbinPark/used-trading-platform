package com.seongbinpark.usedtradingplatform.post.domain.entity;

import com.seongbinpark.usedtradingplatform.commons.BaseTimeEntity;
import com.seongbinpark.usedtradingplatform.member.domain.entity.Address;
import com.seongbinpark.usedtradingplatform.member.domain.entity.Location;
import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member author;

    @Lob
    private String content;

    @Embedded
    private Address address;

    @Embedded
    private Location location;

    @Column(name = "IS_REMOVED")
    private boolean removed = false;


}

