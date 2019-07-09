package liyu.test.hystrix.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class HystrixMainConfigure {
	public static void main(String[] args) {
		SpringApplication.run(HystrixMainConfigure.class, args);
	}
}
