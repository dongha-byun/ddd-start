package hello.ddd.infra;

import static org.assertj.core.api.Assertions.*;

import hello.ddd.domain.Order;
import hello.ddd.domain.OrderNo;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class JpaOrderRepositoryTest {

    @Autowired
    private EntityManager em;

    private JpaOrderRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = new JpaOrderRepository(em);
    }

    @DisplayName("for update 조회 테스트")
    @Test
    void find_by_id_for_update() {
        // given
        OrderNo orderNo = new OrderNo("test-order-no");

        // when
        Order order = repository.findByIdForUpdate(orderNo);

        // then
        assertThat(order).isNull();
    }


    @DisplayName("lock exception 테스트")
    @Test
    void lock_timeout_exception() {
        // given
        OrderNo orderNo = new OrderNo("test-order-no");
        Order order = new Order(orderNo);
        repository.save(order);

        // when
        repository.findByIdForUpdate(orderNo);

        // then
        assertThatThrownBy(
                () -> repository.findByIdForUpdate(orderNo, 2000)
        );
    }


    @DisplayName("version update 확인")
    @Test
    void version_update() {
        // given
        OrderNo orderNo = new OrderNo("test-order-no");
        Order order = new Order(orderNo);
        repository.save(order);

        em.flush();
        em.clear();

        // when
        Order findOrder = repository.findById(orderNo);

        // then
        findOrder.cancel();

        em.flush();
        em.clear();
    }
}