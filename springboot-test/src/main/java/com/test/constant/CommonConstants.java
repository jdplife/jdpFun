package com.test.constant;

/**
 * @ClassName CommonConstants
 * @Description TODO
 * @Author jdp
 * @Date 15:13 2023/2/21
 * @Version 1.0
 **/
public interface CommonConstants {

    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 菜单树根节点
     */
    Long MENU_TREE_ROOT_ID = -1L;

    /**
     * 树根节点  （long）
     */
    Long TREE_ROOT_ID = 0L;

    /**
     * 树根节点 （字符串）
     */
    String ROOT_PARENT_ID = "-1";

    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json; charset=utf-8";

    /**
     * 成功标记
     */
    String SUCCESS_MSG = "成功";

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;

    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 省级后缀 四个0
     */
    String AREA_HZ_PROV = "0000";

    /**
     * 市级后缀 二个0
     */
    String AREA_HZ_CITY = "00";

    /**
     * TSM
     */
    String TSM = "303001";

    /**
     * 密码重置
     */
    String PASSWORD_SET = "123456";

    /**
     * 测试的短信验证码
     */
    String TEST_MOBIL_CODE = "8888";

    /**
     * 登录 clientId ： APP
     */
    String LOGIN_CLIENT_ID_APP = "Basic YXBwOm9hdXRoX2NsaWVudF9pZF9hcHBfc2VjcmV0";

    /**
     * 登录 clientId ： PC
     */
    String LOGIN_CLIENT_ID_PC = "Basic cGM6cGM=";

    /**
     * 多个省份公用
     */
    String PUBLIC_PROJECT_NAME = "紫金保险道路救助基金综合管理平台";

    /**
     * 单个身份用
     */
    String PRIVATE_PROJECT_NAME = "道路救助基金综合管理平台";
}
