package gr.codehub.teamb.acmeshop.repository;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products p WHERE UPPER(p.name) LIKE UPPER('%'||?1||'%')", nativeQuery = true)
    List<Product> findProductsByText(String text);

    List<Product> findProductByCategoryId(long id);

    Product findProductById(Long id);
}
