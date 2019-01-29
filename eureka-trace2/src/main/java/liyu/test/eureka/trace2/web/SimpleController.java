package liyu.test.eureka.trace2.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	private static Logger logger = LoggerFactory.getLogger(SimpleController.class);
	
	@RequestMapping("/trace2")
	public String sccess() {
		logger.info("===<call trace-2>===");
		return "success from trace2.";
	}
}
