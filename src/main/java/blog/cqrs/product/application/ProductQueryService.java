package blog.cqrs.product.application;

import blog.cqrs.product.domain.Product;
import blog.cqrs.product.domain.ProductRepository;
import blog.cqrs.product.application.query.FindProductQuery;

public class ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findByProductId(FindProductQuery findProductQuery) {
        return productRepository.findByProductId(findProductQuery.getProductId())
                .orElseThrow(RuntimeException::new);
    }
}
