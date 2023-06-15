package hello.ddd.blog.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogOrderRepository extends JpaRepository<BlogOrder, BlogOrderNo> {
    Optional<BlogOrder> findById(BlogOrderNo no);
}
