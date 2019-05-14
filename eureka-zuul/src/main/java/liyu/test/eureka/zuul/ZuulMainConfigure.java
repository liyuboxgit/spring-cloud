package liyu.test.eureka.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import sun.rmi.log.LogOutputStream;


@SpringBootApplication
@EnableZuulProxy
public class ZuulMainConfigure {
	/**
	 * call http://localhost:10003/eureka-consumer or 
	 * 		http://localhost:10003/eureka-provider/provider/msg
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ZuulMainConfigure.class, args);	
	}
}
