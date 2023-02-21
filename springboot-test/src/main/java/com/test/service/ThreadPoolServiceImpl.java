package com.test.service;

import com.test.excutor.AsyncManager;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: laizc
 * @Date: Created in  2022-04-26
 * @desc:
 */
@EnableAsync
@Service
@Slf4j
public class ThreadPoolServiceImpl implements ThreadPoolService{

	@Override
	@Async
	@SneakyThrows
	public void asyncTest() {

		TimeUnit.SECONDS.sleep(5);
		log.info("asyncTest");
	}

	@Override
	@SneakyThrows
	public void noAsyncTest() {

		log.info("no-asyncTest");
	}

	@Override
	public void createOrder(int k) {
		//1、同步处理核心业务逻辑
		log.info("同步处理业务逻辑:订单号为：{}",k);
		//2、通过线程池提交异步处理非逻辑，列如日志埋点
		AsyncManager.service.execute(()->{
			try {
				System.out.println("线程-》"+Thread.currentThread().getName()+"正在异步执行日志处理任务====开始");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程-》"+Thread.currentThread().getName()+"正在异步执行日志处理任务====结束");
		});

	}
}
