package com.nchu.day2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test1 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.info("running...");
            }
        };
        t1.run(); // run方法运行的还是main线程
        t1.start();// start方法运行的才是t1线程
    }
}
