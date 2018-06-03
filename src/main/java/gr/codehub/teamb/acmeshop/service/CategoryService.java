package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category addCategory(Category category);
}
