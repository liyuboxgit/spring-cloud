package liyu.test.eureka.zuul;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


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
	
	@Bean
    public MyZuulPreFilter myZuulPreFilter() {
        return new MyZuulPreFilter();
    }
	
	public static class MyZuulPreFilter extends ZuulFilter {
	    private final static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MyZuulPreFilter.class);
	    @Override
	    public String filterType() {
	        return "pre"; // 指定过滤器类型
	    }

	    @Override
	    public int filterOrder() {
	        return 0; // 过滤器顺序，数字越小越先执行
	    }

	    @Override
	    public boolean shouldFilter() {
	        return true; // 是否使用该过滤器。
	    }

	    // 过滤器具体执行的操作
	    @Override
	    public Object run() {
	        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
	        String requestUri = request.getRequestURI();
	        UserEntity user = (UserEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        LOGGER.info("请求的URI：{},用户{}",requestUri,user.getUsername());
	        if("liyu".equals(user.getUsername()))
	        	return null;
	        else {
	        	RequestContext ctx = RequestContext.getCurrentContext();
	        	ctx.setSendZuulResponse(false);  
	            ctx.setResponseStatusCode(401);  
	            ctx.setResponseBody("{\"result\":\"password is not correct!\"}");  
	            ctx.set("isSuccess", false); 
	            return null;
	            //throw new RuntimeException("此用户("+user.getUsername()+")不允许登录") ;
	        }
	    }
	}
	
}
