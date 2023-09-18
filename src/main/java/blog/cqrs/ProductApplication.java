package blog.cqrs;

import blog.cqrs.product.application.InMemoryProductRepository;
import blog.cqrs.product.application.OrderService;
import blog.cqrs.product.application.ProductCommandService;
import blog.cqrs.product.application.ProductQueryService;
import blog.cqrs.product.domain.Product;
import blog.cqrs.product.domain.ProductRepository;
import blog.cqrs.product.application.query.FindProductQuery;

public class ProductApplication {

    private final ProductRepository productRepository = new InMemoryProductRepository();

    private final ProductCommandService productCommandService = new ProductCommandService(productRepository);
    private final ProductQueryService productQueryService = new ProductQueryService(productRepository);

    private final OrderService orderService = new OrderService(productQueryService, productCommandService);

    public static void main(String[] args) {

        ProductApplication application = new ProductApplication();

        application.orderService.newProduct("생수", 3000L);
        application.orderService.order(1L, 200);

        Product product = application.productQueryService.findByProductId(FindProductQuery.build(1L));

        System.out.println(product.getProductName() + ":" + product.getQuantity());
    }
}
