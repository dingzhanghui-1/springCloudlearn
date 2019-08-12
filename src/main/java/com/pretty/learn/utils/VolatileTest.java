package com.pretty.learn.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.pretty.learn.model.VolatileData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileTest {
    /**
     * volatile 学习心得
     * 适用于对变量的写操作不依赖于当前值，对变量的读取操作不依赖于非volatile变量。
     * 适用于读多写少的场景。
     * 可用作状态标志。
     * JDK中volatie应用：JDK中ConcurrentHashMap的Entry的value和next被声明为volatile，AtomicLong中的value被声明为volatile。AtomicLong通过CAS原理(也可以理解为乐观锁)保证了原子性。
     * 4.volatile VS synchronized
     *
     * volatilesynchronized修饰对象修饰变量修饰方法或代码段可见性11有序性11原子性01线程阻塞01对比这个表格，你会不会觉得synchronized完胜volatile，答案是否定的，volatile不会让线程阻塞，响应速度比synchronized高，这是它的优点。
     */



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
