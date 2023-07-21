package hello.ddd.event.basic.common.event;

import org.springframework.context.ApplicationEventPublisher;

/**
 * 생성된 이벤트를 발행하는 publisher 역할을 수행
 */
public class Events {
    private static ApplicationEventPublisher publisher;

    static void setPublisher(ApplicationEventPublisher publisher) {
        Events.publisher = publisher;
    }

    /**
     * 생성된 이벤트를 발행하는 메서드
     * @param event
     */
    public static void raise(Event event) {
        if(publisher != null) {
            publisher.publishEvent(event);
        }
    }

}
