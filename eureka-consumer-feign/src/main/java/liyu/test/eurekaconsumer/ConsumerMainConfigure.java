package liyu.test.eurekaconsumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
//@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
public class ConsumerMainConfigure {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private HiService hiService;
	
	@RequestMapping("/")
	public String sccess() {
		//String ret = restTemplate.getForObject("http://localhost:8762/provider/msg", String.class);
		List<ServiceInstance> list = this.discoveryClient.getInstances("eureka-provider");
		if(list.size()!=0 && list.get(0)!=null){
			URI uri = list.get(0).getUri();
			String ret = restTemplate.getForObject(uri+"/provider/msg", String.class);
			return "success,"+uri+":"+ret;
		}else{
			return "success,"+"no provider finded";
		}
		
	}
	
	@RequestMapping("/2")
	public String sccess2() {
		return hiService.msg();
	}
	
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	/**
	 * @param args，/没有负载均衡的功能，/2有负载均衡的功能
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConsumerMainConfigure.class, args);
	}
}
