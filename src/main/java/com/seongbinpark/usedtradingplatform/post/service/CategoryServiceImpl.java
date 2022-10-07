package com.seongbinpark.usedtradingplatform.post.service;

import com.seongbinpark.usedtradingplatform.post.entity.Category;
import com.seongbinpark.usedtradingplatform.post.exception.CategoryNotFoundException;
import com.seongbinpark.usedtradingplatform.post.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName)
                .orElseThrow(CategoryNotFoundException::new);
    }
}
