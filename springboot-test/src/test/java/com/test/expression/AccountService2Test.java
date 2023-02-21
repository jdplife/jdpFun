package com.test.expression;

import com.test.service.AccountService2;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName AccountService2Test
 * @Description TODO
 * @Author jdp
 * @Date 17:40 2022/5/5
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AccountService2Test {
    @Autowired
    private AccountService2 accountService2;

    @Test
    public void testGetAccountByName() throws Exception {
        log.info("first query...");
        accountService2.getAccountByName("accountName");

        log.info("second query...");
        accountService2.getAccountByName("accountName");
    }

}
