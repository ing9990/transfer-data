package blog.cqrs.product.application.query;

public class FindProductQuery {

    private long productId;

    protected FindProductQuery(long productId) {
        this.productId = productId;
    }

    public static FindProductQuery build(long productId) {
        return new FindProductQuery(productId);
    }

    public long getProductId() {
        return productId;
    }
}
