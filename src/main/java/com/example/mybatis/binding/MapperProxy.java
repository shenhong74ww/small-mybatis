package com.example.mybatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>标题: </p>
 * <p>描述: </p>
 * <p>公司: YeYoo</p>
 *
 * @author Shen Hong
 * @date 2022-07-20 16:55
 */
public class MapperProxy implements InvocationHandler, Serializable {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
