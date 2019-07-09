package liyu.test.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


@SpringBootApplication
@EnableTurbine
public class ServerMainConfigure {
	public static void main(String[] args) {
		SpringApplication.run(ServerMainConfigure.class, args);
	}
}
