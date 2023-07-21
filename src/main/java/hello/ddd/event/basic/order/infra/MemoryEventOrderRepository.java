package hello.ddd.event.basic.order.infra;

import hello.ddd.event.basic.order.domain.EventOrder;
import hello.ddd.event.basic.order.domain.EventOrderRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryEventOrderRepository implements EventOrderRepository {
    private static final Map<Long, EventOrder> store = new HashMap<>();
    private static Long sequence = 1L;

    public EventOrder save(EventOrder order) {
        order.assignId(sequence++);
        store.put(order.getId(), order);

        return order;
    }

    public EventOrder findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<EventOrder> findAll() {
        return store.values().stream().toList();
    }
}
