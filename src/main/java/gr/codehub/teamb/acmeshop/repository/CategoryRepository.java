package gr.codehub.teamb.acmeshop.repository;

import gr.codehub.teamb.acmeshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryById(Long id);
}
