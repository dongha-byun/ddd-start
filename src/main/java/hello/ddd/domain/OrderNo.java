package hello.ddd.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * Entity 에서 사용하는 식별자를 밸류타입으로 지정할 때, Serializable 을 상속받아야 한다.
 */
@Embeddable
public class OrderNo implements Serializable {

    @Column(name = "order_number")
    private String number;

    /**
     * @Embeddable 를 통해 식별자를 밸류타입으로 구현하면
     * 식별자 내에 기능을 구현할 수 있다는 장점이 있다.
     */
    // 식별자에 관련된 기능/검증 로직을 구현할 때 해당 클래스에 구현할 수 있다.
}
