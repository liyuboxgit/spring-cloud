package liyu.test.hystrix.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableHystrix
@RestController
public class HystrixMainConfigure {
	/**
	 * call http://localhost:8080/
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(HystrixMainConfigure.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private SimpleService simpleService;
	
	@RequestMapping("/")
	public String index() {
		return simpleService.consumer();
	}
	
	@RequestMapping("/server")
	public String server() throws InterruptedException {
		Thread.sleep(5000L);
		return "server";
	}
	
}
