package hello.ddd.event.basic.order.domain;

import java.util.List;

public interface EventOrderRepository {

    EventOrder save(EventOrder order);
    EventOrder findById(Long id);
    List<EventOrder> findAll();
}
