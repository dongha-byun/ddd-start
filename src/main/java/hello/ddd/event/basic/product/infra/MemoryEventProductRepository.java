package hello.ddd.event.basic.product.infra;

import hello.ddd.event.basic.product.domain.EventProduct;
import hello.ddd.event.basic.product.domain.EventProductRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryEventProductRepository implements EventProductRepository {
    private static final Map<Long, EventProduct> store = new HashMap<>();
    private static Long sequence = 1L;

    public EventProduct save(EventProduct product) {
        product.assignId(sequence++);
        store.put(product.getId(), product);
        return product;
    }

    public EventProduct findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<EventProduct> findAll() {
        return store.values().stream().toList();
    }
}
