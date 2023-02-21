package com.test.excutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SingleBlockPoolExecutor
 * @Description 自定义一个线程池
 * @Author jdp
 * @Date 10:35 2022/8/19
 * @Version 1.0
 **/
public final class SingleBlockPoolExecutor {

    /**
     * 自定义配置线程池（线程池核心线程数、最大线程数、存活时间设置、采用的队列类型、线程工厂类、线程池拒绝处理类）
     */
    private final ThreadPoolExecutor pool = new ThreadPoolExecutor(30, 100, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(100), new BlockThreadFactory(), new BlockRejectedExecutionHandler());

    public ThreadPoolExecutor getPool() {
        return pool;
    }

    private SingleBlockPoolExecutor() {
    }

    /**
     * 定义线程工厂
     */
    public static class BlockThreadFactory implements ThreadFactory {

        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = SingleBlockPoolExecutor.class.getSimpleName() + "-" + count.addAndGet(1);
            t.setName(threadName);
            return t;
        }
    }

    /**
     * 定义线程池拒绝机制处理类
     */
    public static class BlockRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                //被拒线程再次返回阻塞队列进行等待处理
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 在静态内部类中持有单例类的实例，并且可直接被初始化
     */
    private static class Holder {

        private static SingleBlockPoolExecutor instance = new SingleBlockPoolExecutor();
    }

    /**
     * 调用getInstance方法，事实上是获得Holder的instance静态属性
     *
     * @return
     */
    public static SingleBlockPoolExecutor getInstance() {
        return Holder.instance;
    }

    /**
     * 线程池销毁方法
     */
    public void destroy() {
        if (pool != null) {
            //线程池销毁
            pool.shutdownNow();
        }
    }
}
