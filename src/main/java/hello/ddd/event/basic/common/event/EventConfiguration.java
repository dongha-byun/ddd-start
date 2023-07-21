package hello.ddd.event.basic.common.event;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfiguration {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public InitializingBean eventsInitializer() {
        // Events 의 ApplicationEventPublisher 는 ApplicationContext 의 부모클래스이므로
        // Events 초기화 시, ApplicationContext 를 인자로 사용한다.
        return () -> Events.setPublisher(applicationContext);
    }
}
