package hello.ddd.blog.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "orders")
public class BlogOrder {

    @EmbeddedId
    private BlogOrderNo no;

    @Embedded
    private BlogOrderer orderer;

    @Enumerated(EnumType.STRING)
    private BlogOrderStatus orderStatus;

    @Embedded
    private BlogDeliveryInfo deliveryInfo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "orders_item_list",
            joinColumns = @JoinColumn(name = "order_number")
    )
    private List<BlogOrderItem> orderItems;

    private int totalPrice;

    public BlogOrder(BlogOrderNo no, BlogOrderer orderer, BlogOrderStatus orderStatus, BlogDeliveryInfo deliveryInfo,
                     List<BlogOrderItem> orderItems) {
        this.no = no;
        this.orderer = orderer;
        this.orderStatus = orderStatus;
        this.deliveryInfo = deliveryInfo;
        this.orderItems = orderItems;
        this.totalPrice = calculateTotalPrice();
    }

    private int calculateTotalPrice(){
        return orderItems.stream()
                .mapToInt(BlogOrderItem::getAmounts)
                .sum();
    }
}
