package blog.cqrs.product.application;

import blog.cqrs.product.application.command.SaveProductCommand;
import blog.cqrs.product.domain.Product;
import blog.cqrs.product.domain.ProductRepository;

public class ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(final SaveProductCommand command) {
        Product product = Product.registerProduct(command.getProductName(), command.getQuantity());

        productRepository.save(product);
    }
}
