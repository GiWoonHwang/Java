package dustin.apps;

//import com.mysite.sbb.subscriber.SubscriberListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // 애너테이션을 통해 모든 스트링부트의 설정이 관리된다.
@ComponentScan(basePackages = {"dustin"})
@EntityScan(basePackages = "dustin.libs.entities")
public class SbbApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SbbApplication.class, args);
//		RigoWeb3Configuration test = new RigoWeb3Configuration();
//		System.out.println(test.rigoClient());

//		Subscriber subscriber = new Subscriber("ws://192.168.252.60:26657/websocket");
//		SubscriberCallback callback = (message) -> {
//			System.out.println(message);
//		};
//		subscriber.start(DefaultEventType.NEW_BLOCK, callback);


	}

}
