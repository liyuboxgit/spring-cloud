package liyu.test.eureka.zuul;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPA extends JpaRepository<UserEntity,Long>
{
    public UserEntity findByName(String name);
}