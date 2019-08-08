package com.pretty.learn.utils;

import com.pretty.learn.data.VolatileData;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class VolatileTest {



    public class ThreadDemo  extends Thread
    {
        private VolatileData data;
        private boolean flag =false;

        public ThreadDemo(VolatileData data)
        {
            super();
            this.data = data;
        }

        public ThreadDemo(VolatileData data, boolean flag)
        {
            super();
            this.data = data;
            this.flag =flag; 
        }

        @Override
        public void run() {
            int oldValue = data.getCount();
            log.info(Thread.currentThread().getId() + " oldVaule is " + oldValue);
            if(flag) {
                data.incrment();
                int newValue = data.getCount();
                log.info(Thread.currentThread().getId() + " newValue is " + newValue);
            }
        }
    }

    public static void main(String[] args) {
        VolatileData data = new VolatileData();
        ThreadDemo threadDemo = new VolatileTest().new ThreadDemo(data);
        ThreadDemo threadDemo1 = new VolatileTest().new ThreadDemo(data, true);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            if (i == 0) {
                executorService.submit(threadDemo1);
            } else {
                executorService.submit(threadDemo);
            }
        }
    }
}
