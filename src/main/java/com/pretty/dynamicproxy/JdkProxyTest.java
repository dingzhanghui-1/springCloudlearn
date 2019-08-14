package com.pretty.dynamicproxy;

import com.pretty.cglibproxy.CglibProxy;

public class JdkProxyTest {

   /* public static  void main(String[] args)
    {
        Say say = new ISay();
        MyInvocationHandler handler = new MyInvocationHandler(say);
        Say sayproxy = (Say)handler.getProxy();
        sayproxy.say();
    }*/

    public static  void main(String[] args)
    {
        ISay Isay = new ISay();
        CglibProxy cglibProxy = new CglibProxy(Isay);
        cglibProxy.getProxy()
    }
}
