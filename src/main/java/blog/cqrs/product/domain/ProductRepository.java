package blog.cqrs.product.domain;

import blog.cqrs.product.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findByProductId(long productId);

    void save(Product product);
}
