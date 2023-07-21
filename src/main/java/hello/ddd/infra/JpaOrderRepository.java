package hello.ddd.infra;

import hello.ddd.domain.Order;
import hello.ddd.domain.OrderNo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderRepository {

    private final EntityManager em;

    public JpaOrderRepository(EntityManager em) {
        this.em = em;
    }

    public Order findById(OrderNo no) {
        return em.find(Order.class, no);
    }

    public Order findByIdForUpdate(OrderNo no) {
        return em.find(Order.class, no, LockModeType.PESSIMISTIC_WRITE);
    }

    public Order findByIdForUpdate(OrderNo no, long timeout) {
        Map<String, Object> hint = new HashMap<>();
        hint.put("javax.persistence.lock.timeout", timeout);
        return em.find(Order.class, no, LockModeType.PESSIMISTIC_WRITE, hint);
    }

    public void save(Order order) {
        em.persist(order);
    }

    public List<Order> findByOrdererId(String ordererId, int startRow, int size) {
        return em.createQuery(
                        "select o from Order o "
                                + "where o.ordererId = :ordererId "
                                + "order by o.number.number desc",
                        Order.class)
                .setParameter("ordererId", ordererId)
                .setFirstResult(startRow)
                .setMaxResults(size)
                .getResultList()
                ;
    }

    public void delete(Order order) {
        em.remove(order);
    }
}
