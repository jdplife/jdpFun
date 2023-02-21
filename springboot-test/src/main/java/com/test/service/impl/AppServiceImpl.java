package com.test.service.impl;

import com.test.dao.UserDao;
import com.test.model.User;
import com.test.service.IAppService;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AppServiceImpl
 * @Description TODO
 * @Author jdp
 * @Date 16:46 2022/5/9
 * @Version 1.0
 **/
@Service
@Transactional    //控制事务
@AllArgsConstructor //代替@Autowired
@CacheConfig(cacheNames = "app")
@Slf4j
public class AppServiceImpl implements IAppService {

    private final UserDao userDao;
    @Override
    @Cacheable(key = "'id:'+#id") //当结果的name属性为zhq时，不进行缓存
    public User findOne(Long id) {
        log.info("AppServiceImpl request param id =【{}】",id);
        User user = userDao.selectByPrimary(id);
        return user;
    }
}
