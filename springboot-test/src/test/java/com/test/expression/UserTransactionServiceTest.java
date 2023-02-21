package com.test.expression;

import com.test.service.AccountService3;
import com.test.service.UserTransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName UserTransactionServiceTest
 * @Description TODO
 * @Author jdp
 * @Date 15:59 2022/8/11
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTransactionServiceTest {
    @Autowired
    private UserTransactionService userTransactionService;
    @Test
    public void test1() throws Exception {
        userTransactionService.test("hello");
    }

}
