package hello.ddd.event.basic.order.domain;

import java.util.List;

public class EventOrder {
    private Long id;
    private List<EventOrderItem> items;
    private String orderStatus;

    public EventOrder() {
    }

    public EventOrder(List<EventOrderItem> items, String orderStatus) {
        this.items = items;
        this.orderStatus = orderStatus;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public void cancel() {
        this.orderStatus = "CANCEL";

        //상품 갯수 원복
    }

    public Long getId() {
        return id;
    }

    public List<EventOrderItem> getItems() {
        return items;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
