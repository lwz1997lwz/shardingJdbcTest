package com.lwz.shardingJdbc.config;

/**
 * 数据源配置
 *
 * @author Linweizhe
 * @date 2021/2/2
 **/

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"db.properties"})
public class DataSourceConfig {
}
