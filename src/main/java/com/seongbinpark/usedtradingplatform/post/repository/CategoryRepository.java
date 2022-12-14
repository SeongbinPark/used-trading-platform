package com.seongbinpark.usedtradingplatform.post.repository;

import com.seongbinpark.usedtradingplatform.post.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Optional<Category> findCategoryByName(String categoryName);
}
