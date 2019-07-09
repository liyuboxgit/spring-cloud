package liyu.test.eurekaprovider.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/provider")
public class SimpleController {
	@RequestMapping("/msg")
	public String sccess() {
		System.out.println("ok,......................");//为了查看feign的负载均衡添加的日志
		return "success from provider.1";
	}
	@RequestMapping("/msg2")
	public String sccess2(Long id) {
		return "success from provider "+id;
	}
	@RequestMapping("/msg3")
	public String sccess3(@RequestBody Map<String,String> map) {
		return "success from provider "+map.get("id");
	}
}
