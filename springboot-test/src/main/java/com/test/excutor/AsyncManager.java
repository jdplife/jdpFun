package com.test.excutor;

import java.util.concurrent.ExecutorService;

/**
 * @ClassName AsyncManager
 * @Description TODO
 * @Author jdp
 * @Date 10:40 2022/8/19
 * @Version 1.0
 **/
public class AsyncManager {
    /**
     * 任务处理公共线程池
     */
    public static ExecutorService service = SingleBlockPoolExecutor.getInstance().getPool();
}
