package com.pretty.learn.utils;

import com.pretty.learn.model.VolatileData;

import java.lang.reflect.Constructor;

public class ReflectUtil {

    public static void main(String[] args) throws Exception
    {
        /**
         * 获得Class 对象的三种方式  根据CLass.forName() 已知类的具体地址
         * 根据类的class 属性
         * 根据对象的getClass() 方法
         */
        Class modelClass = Class.forName("com.pretty.learn.model.VolatileData");
        Class modelClass1= VolatileData.class;
        VolatileData data = new VolatileData();
        Class modelclass = data.getClass();


        /**
         * 根据class 获取类的一个对象的方法
         * 根据得到的构造器来得到一个对象
         * 或者直接根据class 对象 newInstance() 方法得到一个对象 可以向下转型
         *
         */
        Constructor constructor1 = modelClass.getConstructor(Integer.class);
        Constructor constructor = modelClass.getConstructor();
        Object dataByReflect = constructor.newInstance();
        Object dataByReflect1 = modelClass1.newInstance();
        VolatileData dataByReflect2 = (VolatileData) constructor1.newInstance(5);
        System.out.println(dataByReflect2.getCount());














    }


}
