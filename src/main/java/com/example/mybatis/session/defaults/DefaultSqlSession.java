package com.example.mybatis.session.defaults;

import com.example.mybatis.binding.MapperRegistry;
import com.example.mybatis.session.Configuration;
import com.example.mybatis.session.SqlSession;

/**
 * <p>标题: </p>
 * <p>描述: </p>
 * <p>公司: YeYoo</p>
 *
 * @author Shen Hong
 * @date 2022-07-22 15:05
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }
}
