package com.pretty.cglibproxy;

import com.pretty.dynamicproxy.ISay;
import com.pretty.dynamicproxy.Say;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 1.需要在项目中引入 cglib 版本jar 包
 * 2.若为非maven 项目 还需引入asm jar包
 * 若类为final 修饰的,则报错
 * 若方法为final  修饰,则代理无效
 * 代理方式(继承)
 *
 */
@Slf4j
public class CglibProxy  implements MethodInterceptor {

    private  Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }


    public Object getProxy()
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        enhancer.setClassLoader(target.getClass().getClassLoader());
        return enhancer.create();
    }

    @Override public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        log.info("cglibProxy start");
        Object object = methodProxy.invokeSuper(obj, objects);
        log.info("cgkibProxy  end");
        return object;
    }

}
