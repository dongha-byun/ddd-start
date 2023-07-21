package hello.ddd.event.basic.order.application;

import hello.ddd.event.basic.common.event.Events;
import hello.ddd.event.basic.order.domain.EventOrder;
import hello.ddd.event.basic.order.domain.EventOrderItem;
import hello.ddd.event.basic.order.domain.EventOrderRepository;
import hello.ddd.event.basic.order.event.OrderCancelEvent;
import hello.ddd.event.basic.product.domain.EventProduct;
import hello.ddd.event.basic.product.domain.EventProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class EventOrderService {
    private final EventOrderRepository orderRepository;
    private final EventProductRepository productRepository;

    public EventOrderService(EventOrderRepository orderRepository, EventProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public EventOrder save(EventOrder order) {
        return orderRepository.save(order);
    }

    public EventOrder findById(Long id) {
        return orderRepository.findById(id);
    }

    public List<EventOrder> findAll() {
        return orderRepository.findAll();
    }

    public EventOrder cancel(Long id) {
        EventOrder order = findById(id);
        order.cancel();

        order.getItems()
                .forEach(
                        // 기존에 productRepository 를 사용하지 않고, 이벤트를 발생시키는 방식으로 대체
                        //this::calculateItemProductQuantity
                        item -> Events.raise(new OrderCancelEvent(item.getProductId(), item.getQuantity()))
                );

        return order;
    }

    private void calculateItemProductQuantity(EventOrderItem item) {
        EventProduct product = productRepository.findById(item.getProductId());
        product.increaseQuantity(item.getQuantity());
    }
}
