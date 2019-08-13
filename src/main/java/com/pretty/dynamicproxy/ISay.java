package com.pretty.dynamicproxy;

public class ISay implements Say {
    @Override
    public void say() {
        System.out.println("say Hello jdk proxy!");
    }
}
