package com.pretty.learn.data;

public class VolatileData {

    public volatile int count = 0;

    public int getCount() {
        return count;
    }

    public void incrment() {
        ++count;
    }
}
