package liyu.test.eureka.trace2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Trace2MainConfigure {
	/**
	 * call http://localhost:10005/trace2
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Trace2MainConfigure.class, args);
	}
}
