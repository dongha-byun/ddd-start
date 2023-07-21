package hello.ddd.domain;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.util.List;

@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD) // JPA 의 매핑처리 방식은 FIELD 와 PROPERTY 가 있는데 PROPERTY 방식은 public get/set 을 필요로 한다.
public class Order {

    // 식별자임을 강조하기 위해, @EmbeddedId 를 사용한다.
    @EmbeddedId
    private OrderNo no;

    @Version
    private long version;

    // @ManyToOne 과 같은 효과지만, 다른 방식
    // @ManyToOne 은 엔티티와 엔티티 간의 관계지만, @ElementCollection / @CollectionTable 는 엔티티와 벨류타입 간의 관계를 표현한다.
    // 차이 : @ManyToOne 은 상대 객체가 @Entity 여야함. @ElementCollection / @CollectionTable 는 @Embeddable 이어야 함.
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "order_line",
            joinColumns = @JoinColumn(name = "order_number")
    )
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    @Embedded
    private Orderer orderer;

    @Embedded
    private ShippingInfo shippingInfo;

    private String orderStatus;

    // AttributeConverter 의 autoApply 가 false 일 때, 아래 주석 해제해야
    //@Convert(converter = MoneyAttributeConverter.class)
    @Column(name = "total_amounts")
    private Money totalAmounts;

    protected Order(){}

    public Order(OrderNo no) {
        this.no = no;
        this.orderStatus = "READY";
    }

    public void cancel() {
        this.orderStatus = "CANCEL";
    }
}
