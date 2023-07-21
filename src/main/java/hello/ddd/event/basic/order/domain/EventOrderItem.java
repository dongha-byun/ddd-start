package hello.ddd.event.basic.order.domain;

public class EventOrderItem {
    private Long productId;
    private int quantity;


    public EventOrderItem() {
    }

    public EventOrderItem(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
