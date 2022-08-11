package com.example.mybatis.session.defaults;

import com.example.mybatis.executor.Executor;
import com.example.mybatis.mapping.Environment;
import com.example.mybatis.session.Configuration;
import com.example.mybatis.session.SqlSession;
import com.example.mybatis.session.SqlSessionFactory;
import com.example.mybatis.session.TransactionIsolationLevel;
import com.example.mybatis.transaction.Transaction;
import com.example.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * <p>标题: </p>
 * <p>描述: </p>
 * <p>公司: YeYoo</p>
 *
 * @author Shen Hong
 * @date 2022-07-22 15:09
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}
