package liyu.test.eurekaconsumer;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="eureka-provider",fallbackFactory=MyFallbackFactory.class)
public interface HiService {
	@RequestMapping("/provider/msg")
	public String msg();
	//feign传递参数，使用requestParam注解，如果目标接口使用requestBody，feign也相应从使用requestBody
	@RequestMapping("/provider/msg2")
	public String msg2(@RequestParam("id") Long id);
	@RequestMapping("/provider/msg3")
	public String msg3(@RequestBody Map<String,String> map);
	
	
}
