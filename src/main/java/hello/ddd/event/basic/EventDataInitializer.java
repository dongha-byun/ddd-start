package hello.ddd.event.basic;

import hello.ddd.event.basic.order.domain.EventOrder;
import hello.ddd.event.basic.order.domain.EventOrderItem;
import hello.ddd.event.basic.order.domain.EventOrderRepository;
import hello.ddd.event.basic.product.domain.EventProduct;
import hello.ddd.event.basic.product.domain.EventProductRepository;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventDataInitializer {

    private final InitService initService;

    public EventDataInitializer(InitService initService) {
        this.initService = initService;
    }

    @PostConstruct
    public void init() {
        initService.init();
    }

    @Component
    static class InitService {

        @Autowired
        EventProductRepository productRepository;

        @Autowired
        EventOrderRepository orderRepository;

        public void init() {
            EventProduct product1 = productRepository.save(new EventProduct("상품1", 1000, 5));
            EventProduct product2 = productRepository.save(new EventProduct("상품2", 2000, 10));
            EventProduct product3 = productRepository.save(new EventProduct("상품3", 3000, 15));

            List<EventOrderItem> items = Arrays.asList(
                    new EventOrderItem(product1.getId(), 2),
                    new EventOrderItem(product2.getId(), 3)
            );
            EventOrder order = new EventOrder(items, "PREPARED");
            orderRepository.save(order);
        }
    }
}
