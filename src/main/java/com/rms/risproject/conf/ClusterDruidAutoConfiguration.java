package com.rms.risproject.conf;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.rms.risproject.ordermapper"}, sqlSessionFactoryRef = "sqlSessionFactory2")
public class ClusterDruidAutoConfiguration {

    @Autowired
    @Qualifier("clusterDataSource")
    private DataSource clusterDataSource;


    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(clusterDataSource); // 使用titan数据源, 连接titan库
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2()); // 使用上面配置的Factory
        return template;
    }
}
