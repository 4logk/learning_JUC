package com.nchu.day2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test2 {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            int count = 0;
          for(;;) {
              log.info("{}",count++);
          }
        };
        Runnable task2 = () -> {
            int count = 0;
            for(;;) {
                log.info("{}",count++);
            }
        };
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
