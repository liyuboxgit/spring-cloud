package liyu.test.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientMainConfigure {
	@Value("${name}")
	private	 String name;
	@Value("${age}")
	private	 String age;
	@Value("${version}")
	private	 String version="开发环境";
	@Value("${password}")
	private	 String password;
	@RequestMapping("/")
	public String index() {
		return "config:name="+name+",age="+age+",version="+version+",password="+password;
	}
	/**
	 * http://localhost:9001/
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientMainConfigure.class, args);
	}
}
