package liyu.test.hystrix.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard
public class HystrixMainConfigure {
	//打开http://localhost:8768/hystrix，输入http://localhost:10002/hystrix.stream
	public static void main(String[] args) {
		SpringApplication.run(HystrixMainConfigure.class, args);
	}
}
