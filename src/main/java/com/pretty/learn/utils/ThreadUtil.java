package com.pretty.learn.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class ThreadUtil {

    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock= readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();


    public void read()
    {
        try
        {
            readLock.lock();
            log.info(Thread.currentThread().getName() + " thread exec read start");
            Thread.sleep(3000);
            log.info(Thread.currentThread().getName() + " thread exec read success");
        }
        catch (Exception e)
        {
            log.error("read error",e);
        }
        finally {
            readLock.unlock();
        }
    }


    public void write()
    {
        try
        {
            writeLock.lock();
            log.info(Thread.currentThread().getName() + " wirte thread start");
            Thread.sleep(3000);
            log.info(Thread.currentThread().getName()+  " write thread success");
        }
        catch (Exception e)
        {
            log.error("writer error");
        }
        finally {
            writeLock.unlock();
        }
    }



    public static void main(String[] args)
    {
        ThreadUtil util = new ThreadUtil();
        Thread thread1 = new Thread(() -> {log.info("thread 1 execut");
        util.read();}, "t1");

        Thread thread2 = new Thread(() -> {log.info("thread 2 execut");
            util.read();}, "t2");

        Thread thread3 = new Thread(() -> {log.info("thread 3 execut");
            util.write();}, "t3");

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
