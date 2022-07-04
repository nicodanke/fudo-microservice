package nd.dev.serviceproduct.repository;

import nd.dev.serviceproduct.Category;
import nd.dev.serviceproduct.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
