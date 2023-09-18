package blog.cqrs.product.application.command;

public class SaveProductCommand {
    private String productName;

    private long quantity;

    protected SaveProductCommand(String productName, long quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public static SaveProductCommand build(final String productName, final long quantity) {
        if (quantity < 1) {
            throw new RuntimeException("수량이 부족합니다.");
        }
        return new SaveProductCommand(productName, quantity);
    }

    public String getProductName() {
        return productName;
    }

    public long getQuantity() {
        return quantity;
    }
}
