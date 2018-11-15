package com.rms.risproject.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.rms.risproject.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MasterDruidAutoConfiguration {

    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;


    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(masterDataSource); // 使用titan数据源, 连接titan库

        return factoryBean.getObject();

    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1()); // 使用上面配置的Factory
        return template;
    }
}

