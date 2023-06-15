package hello.ddd.blog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class BlogAddress {
    @Column(name = "delivery_address")
    private String address;

    @Column(name = "delivery_detail_address")
    private String detailAddress;

    @Column(name = "delivery_zip_code")
    private String zipCode;
}
