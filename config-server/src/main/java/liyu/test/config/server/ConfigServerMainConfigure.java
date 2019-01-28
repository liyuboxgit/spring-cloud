package liyu.test.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ConfigServerMainConfigure {
	/**
	 * http://localhost:9000/lisiService/prod or http://localhost:9000/lisiService/dev
	 * http://localhost:9000/lisiService-prod.yml
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerMainConfigure.class, args);
	}
}
