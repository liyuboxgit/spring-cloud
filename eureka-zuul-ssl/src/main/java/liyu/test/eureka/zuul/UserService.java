package liyu.test.eureka.zuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService
{
    @Autowired
    UserJPA userJPA;
 
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserEntity user = userJPA.findByName(name);
        if(user == null)
        {
            throw new UsernameNotFoundException("未查询到用户："+name+"信息！");
        }
        return user;
    }
}