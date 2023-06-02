package hello.ddd.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class ShippingInfo {

    @Column(name = "shipping_message")
    private String message;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="zipCode", column = @Column(name = "shipping_zipcode")),
            @AttributeOverride(name="address1", column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name="address2", column = @Column(name = "shipping_addr2"))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="name", column = @Column(name = "order_name")),
            @AttributeOverride(name="phone", column = @Column(name = "order_phone"))
    })
    private Receiver receiver;

}
