package hello.ddd.blog.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class BlogDeliveryInfo {

    @Embedded
    private BlogAddress address;

    @Embedded
    private BlogReceiver receiver;
}
