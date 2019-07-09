package liyu.test.eureka.trace1.web;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	private static Logger logger = LoggerFactory.getLogger(SimpleController.class);
	
	@RequestMapping("/trace1")
	public String sccess() {
		//logger.info("===<call trace-1>===");
		List<ServiceInstance> list = this.discoveryClient.getInstances("eureka-trace2");
		if(list.size()!=0 && list.get(0)!=null){
			URI uri = list.get(0).getUri();
			return restTemplate.getForEntity(uri+"/trace2", String.class).getBody();
		}else {			
			return "error";
		}
	}
}
