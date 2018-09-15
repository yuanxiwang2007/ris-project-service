package com.rms.risproject.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author wk
 * @since 2017/2/5.
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = "druid", name = "url")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfiguration {

    @Autowired
    private DruidProperties properties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
//    @Bean
//    public DataSource getDataSource() {
//        return buildDataSource();
//    }
//
//    private DataSource buildDataSource() {
//        //设置分库映射
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//        //添加两个数据库ds_0,ds_1到map里
//        dataSourceMap.put("urine2017", createDataSource("urine2017"));
//        dataSourceMap.put("urine2018", createDataSource("urine2018"));
//        //设置默认db为ds_0，也就是为那些没有配置分库分表策略的指定的默认库
//        //如果只有一个库，也就是不需要分库的话，map里只放一个映射就行了，只有一个库时不需要指定默认库，但2个及以上时必须指定默认库，否则那些没有配置策略的表将无法操作数据
//        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap, "urine2017");
//
//        //设置分表映射，将t_order_0和t_order_1两个实际的表映射到t_order逻辑表
//        //0和1两个表是真实的表，t_order是个虚拟不存在的表，只是供使用。如查询所有数据就是select * from t_order就能查完0和1表的
//        TableRule orderTableRule = TableRule.builder("UrineOrder")
//                .actualTables(Arrays.asList("t_order_0", "t_order_1"))
//                .dataSourceRule(dataSourceRule)
//                .build();
//
//        //具体分库分表策略，按什么规则来分
//        ShardingRule shardingRule = ShardingRule.builder()
//                .dataSourceRule(dataSourceRule)
//                .tableRules(Arrays.asList(orderTableRule))
//                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ModuloDatabaseShardingAlgorithm()))
//                .tableShardingStrategy(new TableShardingStrategy("order_id", new ModuloTableShardingAlgorithm())).build();
//
//        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
//
//        return dataSource;
//    }
//
//    private static DataSource createDataSource(final String dataSourceName) {
//        //使用druid连接数据库
//        DruidDataSource result = new DruidDataSource();
//        result.setDriverClassName(Driver.class.getName());
//        result.setUrl(String.format("jdbc:mysql://localhost:3306/%s", dataSourceName));
//        result.setUsername("root");
//        result.setPassword("");
//        return result;
//    }
}

