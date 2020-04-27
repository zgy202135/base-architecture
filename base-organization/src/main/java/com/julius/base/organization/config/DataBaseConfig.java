package com.julius.base.organization.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.config
 * @Author Julius Zhou
 * @Date 2020-04-26 21:20
 * @Description: 数据库配置类
 */
@Configuration
public class DataBaseConfig {


    private static final Logger log  = LoggerFactory.getLogger(DataBaseConfig.class);

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;


    @Bean
    public DataSource dataSource(){
        //使用Tomcat数据库连接池
        DataSource dataSource = new DataSource();
        dataSource.setUrl(datasourceUrl);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        //解决Hibernate+mysql 8小时断开连接问题
        dataSource.setValidationQuery(" select 1 ");
        dataSource.setTestOnConnect(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(18800);

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(driverClassName);
            String var1 = datasourceUrl.substring(0,datasourceUrl.indexOf("?"));
            String var2 = var1.substring(0,var1.lastIndexOf("/"));
            String datasourceName = var1.substring(var1.lastIndexOf("/")+1);
            connection = DriverManager.getConnection(var2,userName,password);
            statement = connection.createStatement();
            log.info("create database {}",datasourceName);
            statement.executeUpdate("create database if not exists `" + datasourceName + "` default character set utf8 COLLATE utf8_general_ci");
        }catch (Exception e){
            log.error("connection failed:[{}]",e.getMessage());
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return dataSource;
    }



}
