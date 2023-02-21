package com.test;

import com.test.model.User;
import com.test.service.IAppService;
import com.test.service.MainService;
import com.test.service.UserService;
import com.test.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootTestApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private MainService mainService;

    @Autowired
    private IAppService appService;

    @Autowired
    private RedisUtils redisUtils;
    @Test
    public void contextLoads() {
        log.info("=========================开始=========================");
        userService.insertName("json");
        log.info("=========================结束=========================");
    }


    @Test
    public void testUserAndDept() {
        log.info("=========================开始=========================");
        appService.findOne(1L);

        Object o = redisUtils.get("app::id:1");
        if(o instanceof User){
            User user = (User) o;
            log.info("app::id:1 = 【{}】",user);
        }

        appService.findOne(1L);
        log.info("=========================结束=========================");
    }


    /**
     * 以下是 required
     * @throws Exception
     */
    @Test
    public void required() throws Exception {
        mainService.mainTest1("required");
    }

    @Test
    public void required_1() throws Exception {
        mainService.mainTest1_1("required_1");
    }

    @Test
    public void required_2() throws Exception {
        mainService.mainTest1_2("required_2");
    }

    /**
     * support
     */
    @Test
    public void support() throws Exception {
        mainService.mainTest2("support");
    }

    @Test
    public void support_1() throws Exception {
        mainService.mainTest2_1("support_1");
    }

    /**
     * mandatory 强制
     */
    @Test
    public void mandatory() throws Exception {
        mainService.mainTest3("mandatory");
    }

    @Test
    public void mandatory_1() throws Exception {
        mainService.mainTest3_1("mandatory_2");
    }

    /**
     * requires_new
     */
    @Test
    public void requiresNew() throws Exception {
        mainService.mainTest4("requires_new");
    }

    @Test
    public void requiresNew_1() throws Exception {
        mainService.mainTest4_1("requires_new_1");
    }

    @Test
    public void requiresNew_2() throws Exception {
        mainService.mainTest4_2("requires_new_2");
    }

    @Test
    public void requiresNew_3() {
        mainService.mainTest4_3("requires_new_3");
    }

    /**
     * not supported
     */
    @Test
    public void notSupported() throws Exception {
        mainService.mainTest5("not_supported");
    }

    @Test
    public void notSupported_1() throws Exception {
        mainService.mainTest5_1("not_supported_1");
    }

    /**
     * never
     */
    @Test
    public void never() throws Exception {
        mainService.mainTest6("never");
    }

    @Test
    public void never_1() throws Exception {
        mainService.mainTest6_1("never_1");
    }

    /**
     * NESTED nested
     */
    @Test
    public void nested() throws Exception {
        mainService.mainTest7("nested");
    }

    @Test
    public void nested_1() {
        mainService.mainTest7_1("nested-1");
    }

    @Test
    public void nested_2() throws Exception {
        mainService.mainTest7_2("nested-2");
    }

}
