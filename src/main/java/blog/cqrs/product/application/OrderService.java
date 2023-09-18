package blog.cqrs.product.application;


import blog.cqrs.product.application.command.SaveProductCommand;
import blog.cqrs.product.domain.Product;
import blog.cqrs.product.application.query.FindProductQuery;

public class OrderService {

    private final ProductQueryService productQueryService;
    private final ProductCommandService productCommandService;

    public OrderService(ProductQueryService productQueryService, ProductCommandService productCommandService) {
        this.productQueryService = productQueryService;
        this.productCommandService = productCommandService;
    }

    public void order(final long productId, final long quantity) {
        Product product = productQueryService.findByProductId(FindProductQuery.build(productId));

        product.decreaseQuantity(quantity);

        // 기타 주문 로직
    }

    public void newProduct(final String productName, final long quantity) {
        productCommandService.save(SaveProductCommand.build(productName, quantity));
    }

}
