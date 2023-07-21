package hello.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @EnableAsync : 비동기 이벤트 처리를 위해 EventListener 를 비동기처리 하겠다는 어노테이션
 */
@EnableAsync
@SpringBootApplication
public class DddApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddApplication.class, args);
	}

}
