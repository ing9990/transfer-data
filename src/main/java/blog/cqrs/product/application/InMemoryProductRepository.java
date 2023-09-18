package blog.cqrs.product.application;

import blog.cqrs.product.domain.Product;
import blog.cqrs.product.domain.ProductRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {

    Map<Long, Product> memory = new HashMap<>();

    @Override
    public Optional<Product> findByProductId(long productId) {
        Product product = memory.get(productId);

        if (Objects.isNull(product)) {
            return Optional.empty();
        }

        return Optional.of(product);
    }

    @Override
    public void save(Product product) {
        memory.put(product.getId(), product);
    }
}
