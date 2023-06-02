package hello.ddd.application;

import hello.ddd.domain.CancelPolicy;
import hello.ddd.domain.Canceller;
import hello.ddd.domain.NoCancellablePermissionException;
import hello.ddd.domain.NoOrderException;
import hello.ddd.domain.Order;
import hello.ddd.domain.OrderNo;
import hello.ddd.domain.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancelOrderService {
    private final OrderRepository orderRepository;
    private final CancelPolicy cancelPolicy;

    public CancelOrderService(OrderRepository orderRepository, CancelPolicy cancelPolicy) {
        this.orderRepository = orderRepository;
        this.cancelPolicy = cancelPolicy;
    }

    @Transactional
    public void cancel(OrderNo orderNo, Canceller canceller) {
        Order order = orderRepository.findById(orderNo)
                .orElseThrow(NoOrderException::new);

        if(!cancelPolicy.hasCancellationPermission(order, canceller)) {
            throw new NoCancellablePermissionException();
        }

        order.cancel();
    }
}
