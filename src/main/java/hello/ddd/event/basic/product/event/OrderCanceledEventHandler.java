package hello.ddd.event.basic.product.event;

import hello.ddd.event.basic.order.event.OrderCancelEvent;
import hello.ddd.event.basic.product.domain.EventProduct;
import hello.ddd.event.basic.product.domain.EventProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * event handler 가 동작하는 시점은, 이벤트가 발생한 이후 이므로
 * class 명을 작성할 때, 해당 이벤트가 과거에 발생한 것임을 명시하기 위해 과거형을 써준다.
 */
@Slf4j
@Service
public class OrderCanceledEventHandler {
    private final EventProductRepository productRepository;

    public OrderCanceledEventHandler(EventProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * @Async : EventListener 를 비동기 처리한다는 의미
     */
    @Async
    @EventListener(OrderCancelEvent.class)
    public void handler(OrderCancelEvent event) throws InterruptedException {
        Thread.sleep(2000);
        log.info("EVENT HANDLER CALLED! => event={}", event.toString());
        EventProduct product = productRepository.findById(event.getProductId());
        product.increaseQuantity(event.getQuantity());
    }
}
