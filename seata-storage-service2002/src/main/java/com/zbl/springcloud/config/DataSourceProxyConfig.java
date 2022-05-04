package com.zbl.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/5/4 16:57
 */
@Configuration
public class DataSourceProxyConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean
    public DataSourceProxy dataSource(DruidDataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource());
    }

    @Bean
    public SqlSessionFactory sessionFactory(DataSourceProxy dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setDefaultScriptingLanguage(RawLanguageDriver.class);
        factoryBean.setConfiguration(configuration);
        factoryBean.setTransactionFactory(new SpringManagedTransactionFactory());

        return factoryBean.getObject();
    }
}
