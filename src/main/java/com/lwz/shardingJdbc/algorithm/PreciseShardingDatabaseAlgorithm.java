package com.lwz.shardingJdbc.algorithm;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 数据库精准分片策略,需实现PreciseShardingAlgorithm接口，泛型为分片列的类型。本例按学号sno分片，其类型为Long。
 * 重写doSharding方法，实现具体分库逻辑。
 */
public class PreciseShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Long> {

    /**
     * 学号sno按数据库数量取模，模为0分片到数据库db0，模为1分片到数据库db1
     *
     * @param dbNames              所有库名的集合，本例为[db0,db1]
     * @param preciseShardingValue 精确分片值,其有三个final属性，String columnName（分片列名：本例为sno），
     *                             String logicTableName（逻辑表名：本例为student），
     *                             T value（分片列的值：本例为sno的值）
     * @return 库名
     */
    @Override
    public String doSharding(Collection<String> dbNames, PreciseShardingValue<Long> preciseShardingValue) {

        Long mod = preciseShardingValue.getValue() % dbNames.size();

        for (String dbName : dbNames) {
            if (dbName.endsWith(String.valueOf(mod))) {
                return dbName;
            }
        }

        throw new UnsupportedOperationException();
    }
}

