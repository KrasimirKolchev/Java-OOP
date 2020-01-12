package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class OrderItem {
    private String sku;
    private int quantity;

    public OrderItem(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
