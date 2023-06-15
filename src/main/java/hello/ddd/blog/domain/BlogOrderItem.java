package hello.ddd.blog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class BlogOrderItem {

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "amounts")
    private int amounts;

    public BlogOrderItem (String productId, int quantity, int price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.amounts = this.quantity * this.price;
    }
}
