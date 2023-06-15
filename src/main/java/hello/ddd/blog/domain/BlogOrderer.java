package hello.ddd.blog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class BlogOrderer {

    @Column(name = "orderer_name")
    private String name;

    @Column(name = "orderer_phone_number")
    private String phoneNumber;

}
