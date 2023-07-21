package hello.ddd.event.basic.product.domain;

import java.util.List;
import org.springframework.stereotype.Repository;

public interface EventProductRepository {
    EventProduct save(EventProduct product);
    EventProduct findById(Long id);

    List<EventProduct> findAll();
}
