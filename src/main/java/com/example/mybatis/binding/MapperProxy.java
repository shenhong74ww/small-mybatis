package com.example.mybatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * <p>标题: </p>
 * <p>描述: </p>
 * <p>公司: YeYoo</p>
 *
 * @author Shen Hong
 * @date 2022-07-20 16:55
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private Map<String, String> sqlSession;

    private Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
