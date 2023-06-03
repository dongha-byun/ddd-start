package hello.ddd.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderNo> {
    Optional<Order> findById(OrderNo no); // null 반환에 위험이 있어 Optional 을 사용해도 된다.

    Order save(Order order);

    //List<Order> findByOrdererId(String ordererId, int startRow, int size);

    void delete(Order order);
}
