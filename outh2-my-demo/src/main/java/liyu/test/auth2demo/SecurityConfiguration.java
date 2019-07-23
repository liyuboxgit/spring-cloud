package liyu.test.auth2demo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
    DataSource dataSource;
    @Bean
    @Override
    protected UserDetailsService userDetailsService(){    	
    	return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				List<Map<String, Object>> list = new JdbcTemplate(dataSource).queryForList("select username,password from sys_user where username=?", username);
				if(list.isEmpty()) {
					throw new UsernameNotFoundException(username);
				}else {
					Map<String, Object> map = list.get(0);
					String un = (String) map.get("username");
					String up = (String) map.get("password");
					Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
					grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
					User user = new User(un, up, grantedAuthorities);
					return user;
				}
			}
		};
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .requestMatchers().anyRequest()
            .and()
                .authorizeRequests()
                .antMatchers("/oauth/*").permitAll();
        // @formatter:on
    }
}
