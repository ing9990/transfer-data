package blog.cqrs.product.application;

import blog.cqrs.product.domain.Product;
import blog.cqrs.product.domain.ProductRepository;

@Deprecated(since = "조회와 명령을 분리한다.")
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void findById(final long productId) {
        Product product = productRepository.findByProductId(productId)
                .orElseThrow(RuntimeException::new);
    }

    public void save(final Product product) {
        productRepository.save(product);
    }
}
