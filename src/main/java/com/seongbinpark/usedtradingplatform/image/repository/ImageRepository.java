package com.seongbinpark.usedtradingplatform.image.repository;

import com.seongbinpark.usedtradingplatform.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {


}
