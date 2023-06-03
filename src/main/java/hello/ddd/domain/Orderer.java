package hello.ddd.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Orderer {

    // 어떤 의미인지 한번 공부해볼 필요가 있다.
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    @Embedded
    private MemberId id;

    @Column(name = "orderer_name")
    private String name;

    public MemberId getId() {
        return id;
    }
}
