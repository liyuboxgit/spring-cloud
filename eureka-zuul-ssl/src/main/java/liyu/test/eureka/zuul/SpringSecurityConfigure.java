package liyu.test.eureka.zuul;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigure extends WebSecurityConfigurerAdapter{
	@Bean
	protected
    UserDetailsService userDetailsService(){
        return new UserService();
    }
	
	protected void configure(HttpSecurity http) throws Exception {
		/*UserDetailsService userDetailsService = new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return User.withUsername("user").password("password").roles("USER").build();
			}
		};
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);*/
		
		http
	    	//.authenticationProvider(authenticationProvider)
	        .authorizeRequests()
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .and()
	        .logout()
	        	.and()
        	.csrf().disable()
	        .httpBasic();
	}
}
