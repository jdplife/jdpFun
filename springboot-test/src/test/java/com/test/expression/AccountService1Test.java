package com.test.expression;

import com.test.service.AccountService1;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName AccountService1Test
 * @Description TODO
 * @Author jdp
 * @Date 15:12 2022/5/5
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AccountService1Test {
    @Autowired
    private AccountService1 accountService1;
    @Test
    public void testGetAccountByName() throws Exception {
        accountService1.getAccountByName("accountName");
        accountService1.getAccountByName("accountName");

        accountService1.reload();
        log.info("after reload ....");

        accountService1.getAccountByName("accountName");
        accountService1.getAccountByName("accountName");
    }
}
