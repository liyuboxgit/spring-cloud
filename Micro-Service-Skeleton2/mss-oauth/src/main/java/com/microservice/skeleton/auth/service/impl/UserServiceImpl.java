package com.microservice.skeleton.auth.service.impl;

import com.microservice.skeleton.auth.service.UserService;
import com.microservice.skeleton.common.vo.Result;
import com.microservice.skeleton.common.vo.UserVo;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:56
 */
@Service
//@Slf4j
public class UserServiceImpl implements UserService {
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
    public Result<UserVo> findByUsername(String username) {
        log.info("调用{}失败","findByUsername");
        return Result.failure(100,"调用findByUsername接口失败");
    }
}
