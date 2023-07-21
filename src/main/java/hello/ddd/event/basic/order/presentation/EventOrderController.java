package hello.ddd.event.basic.order.presentation;

import hello.ddd.event.basic.order.application.EventOrderService;
import hello.ddd.event.basic.order.domain.EventOrder;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/event")
@RestController
public class EventOrderController {
    private final EventOrderService orderService;

    public EventOrderController(EventOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<EventOrder> findById(@PathVariable("id") Long id) {
        EventOrder order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }

    @PostMapping("/orders")
    public ResponseEntity<EventOrder> save(@RequestBody EventOrder order) {
        EventOrder savedOrder = orderService.save(order);
        return ResponseEntity.created(URI.create("/orders"+savedOrder.getId())).body(savedOrder);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<EventOrder>> findAll() {
        List<EventOrder> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @PatchMapping("/orders/{id}/cancel")
    public ResponseEntity<EventOrder> cancel(@PathVariable("id") Long id) {
        EventOrder order = orderService.cancel(id);
        return ResponseEntity.ok(order);
    }
}
