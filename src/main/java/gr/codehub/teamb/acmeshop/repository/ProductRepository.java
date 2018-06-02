package gr.codehub.teamb.acmeshop.repository;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products p WHERE UPPER(p.name) LIKE UPPER('%'||?1||'%')", nativeQuery = true)
    List<Product> findProductsByText(String text);
    List<Product> findAllByCategory(Category category);
    Product findProductById(Long id);

    @Query(value = "select top 10 * from products where id in (select product_id from order_products where product_id group by product_id order by count(*) desc)", nativeQuery = true)
    List<Product> mostPurchsedProduct();

}
