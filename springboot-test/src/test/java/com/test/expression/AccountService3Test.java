package com.test.expression;

import com.test.model.Account;
import com.test.service.AccountService3;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName AccountService3Test
 * @Description TODO
 * @Author jdp
 * @Date 16:39 2022/5/6
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AccountService3Test {

    @Autowired
    private AccountService3 accountService3;

    @Test
    public void testGetAccountByName() throws Exception {

        log.info("first query.....");
        Account accountFirst = accountService3.getAccountByName("accountName1");
        log.info("first query.....【Account.name】= {}",accountFirst.getName());
        log.info("second query....");
        Account accountSecond = accountService3.getAccountByName("accountName2");
        log.info("second query.....【Account.name】= {}",accountSecond.getName());

    }

    @Test
    public void testUpdateAccount() throws Exception {
        Account account1 = accountService3.getAccountByName("accountName1");
        log.info(account1.toString());
        Account account2 = accountService3.getAccountByName("accountName2");
        log.info(account2.toString());

        account2.setId(121212);
        accountService3.updateAccount(account2);

        // account1会走缓存
        account1 = accountService3.getAccountByName("accountName1");
        log.info(account1.toString());
        // account2会查询db
        account2 = accountService3.getAccountByName("accountName2");
        log.info(account2.toString());

    }

    @Test
    public void testReload() throws Exception {

        // 这2行查询数据库
        accountService3.getAccountByName("somebody1");
        accountService3.getAccountByName("somebody2");
        accountService3.reload();
        // 这两行走缓存
        accountService3.getAccountByName("somebody1");
        accountService3.getAccountByName("somebody2");
    }

}
