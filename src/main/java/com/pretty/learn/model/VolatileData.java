package com.pretty.learn.model;

public class VolatileData {

    public volatile int count = 0;

    public int getCount() {
        return count;
    }

    public void incrment() {
        ++count;
    }


    public VolatileData(Integer count) {
        this.count = count;
    }

    public VolatileData()
    {
        super();
    }


}
