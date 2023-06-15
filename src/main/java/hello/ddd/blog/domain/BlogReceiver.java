package hello.ddd.blog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class BlogReceiver {

    @Column(name = "receiver_name")
    private String name;

    @Column(name = "receiver_phone_number")
    private String phoneNumber;
}
