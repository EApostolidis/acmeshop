package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CategoryServiceImpl implements CategoryService {

    static Logger log = Logger.getLogger(CategoryServiceImpl.class.getName());

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return  categoryRepository.findCategoryById(id);
    }

    @Override
    public Category addCategory(Category category) {
        categoryRepository.save(category);
        log.info("Category saved :" + category);
        return category;
    }
}
