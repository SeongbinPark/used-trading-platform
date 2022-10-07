package com.seongbinpark.usedtradingplatform.post.service;

import com.seongbinpark.usedtradingplatform.post.entity.Category;

public interface CategoryService {

    public Category findCategoryByName(String categoryName);
}
