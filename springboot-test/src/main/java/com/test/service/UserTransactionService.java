package com.test.service;

import com.test.dao.UserDao;
import com.test.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName UserTransactionService
 * @Description TODO
 * @Author jdp
 * @Date 15:30 2022/8/11
 * @Version 1.0
 **/
@Service
public class UserTransactionService {
    @Resource
    private UserDao userDao;

    @Transactional(rollbackFor = RuntimeException.class)
    public String test(String name) throws Exception {
        int i = userDao.test();
        try {
            int a = 2/0;
            if(i > 0){
                return "success";
            }
            return "error";
        }catch (Exception e){
            throw new Exception();
        }

    }
}
