package liyu.test.eurekaconsumer;

import java.util.Map;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
@Component
public class MyFallbackFactory implements FallbackFactory<HiService>{

	@Override
	public HiService create(Throwable arg0) {
		return new HiService() {
			
			@Override
			public String msg3(Map<String, String> map) {
				// TODO Auto-generated method stub
				return null;
			}
					
			@Override
			public String msg() {
				System.err.println(arg0);
				arg0.printStackTrace();
				return "error from hystrix.";
			}

			@Override
			public String msg2(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
	}

}
