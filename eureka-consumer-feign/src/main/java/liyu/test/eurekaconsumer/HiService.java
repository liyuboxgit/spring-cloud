package liyu.test.eurekaconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-provider")
public interface HiService {
	@GetMapping("/provider/msg")
	public String msg();
}
