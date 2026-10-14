package com.nchu.day1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class Test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 方法1：继承Thread类
        Thread t1 = new Thread() {
            @Override
            public void run() {
                log.info("running...");
            }
        };
        t1.setName("t1");
        t1.start();
        //方法2：实现runnable接口
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                log.info("running...");
            }
        };
        Thread t2 = new Thread(runnable, "t2");
        t2.start();
        //方法3：实现callable接口
        Callable<Integer> callable = new Callable() {
            @Override
            public Integer call() throws Exception {
                log.info("running...");
                Thread.sleep(2000);
                return 100;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t3 = new Thread(futureTask,"t3");
        t3.start();
        log.info("{}",futureTask.get());
    }
}
