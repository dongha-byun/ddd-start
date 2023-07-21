package hello.ddd.event.basic.product.presentation;

import hello.ddd.event.basic.product.application.EventProductService;
import hello.ddd.event.basic.product.domain.EventProduct;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/event")
@RestController
public class EventProductController {

    private final EventProductService productService;

    public EventProductController(EventProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<EventProduct>> findAll() {
        List<EventProduct> products = productService.findAll();
        return ResponseEntity.ok(products);
    }
}
