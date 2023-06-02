package hello.ddd.domain;

import org.springframework.stereotype.Component;

@Component
public class CancelPolicy {

    public boolean hasCancellationPermission(Order order, Canceller canceller) {
        return true;
    }
}
