package com.example.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/12
 */
@Configuration
@Slf4j
public class DataSourceConfig {

    @Autowired
    Environment environment;
    @Autowired
    DataSourceProperties dataSourceProperties;

    /*@Bean
    public DataSource dataSource(){
        String property = environment.getProperty("spring.datasource.type");
        log.info("==================================");
        log.info("==================================");
        log.info("=====spring.datasource.type=======");
        log.info("===========   {}    =============",property);
        log.info("==================================");
        log.info("==================================");
        //DataSourceProperties dataSourceProperties = SpringUtils.getApplicationContext().getBean(DataSourceProperties.class);
        log.info(" {} ",dataSourceProperties);

        String driverClassName = dataSourceProperties.getDriverClassName();


        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        return druidDataSource;
    }*/
}
