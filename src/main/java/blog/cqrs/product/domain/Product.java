package blog.cqrs.product.domain;

public class Product {

    private static long AUTO_INCREMENT = 0;

    private long id;

    private String productName;

    private long quantity;

    private Product() {
    }

    protected Product(long id, String productName, long quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }

    public static Product registerProduct(String productName, long quantity) {
        if (quantity < 1) {
            throw new RuntimeException("수량이 부족합니다.");
        }


        return new Product(Product.GET_AUTO_INCREMENT(), productName, quantity);
    }

    public synchronized static long GET_AUTO_INCREMENT() {
        return ++AUTO_INCREMENT;
    }

    public void decreaseQuantity(final long quantity) {
        this.quantity = this.quantity - quantity;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public long getQuantity() {
        return quantity;
    }
}