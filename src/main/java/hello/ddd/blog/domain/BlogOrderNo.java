package hello.ddd.blog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class BlogOrderNo {

    @Column(name = "order_number")
    private String number;
}
