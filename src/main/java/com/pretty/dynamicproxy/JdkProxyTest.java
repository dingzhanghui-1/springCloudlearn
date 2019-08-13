package com.pretty.dynamicproxy;

public class JdkProxyTest {

    public static  void main(String[] args)
    {
        Say say = new ISay();
        MyInvocationHandler handler = new MyInvocationHandler(say);
        Say sayproxy = (Say)handler.getProxy();
        sayproxy.say();
    }
}
