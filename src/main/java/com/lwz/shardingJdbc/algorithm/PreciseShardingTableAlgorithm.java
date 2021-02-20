package com.lwz.shardingJdbc.algorithm;
/**
 * 切表策略
 *
 * @author Linweizhe
 * @date 2021/2/2
 **/

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 表精准分片策略,需实现PreciseShardingAlgorithm接口，泛型为分片列的类型。本例按学号sno分片，其类型为Long。
 * 重写doSharding方法，实现具体分库逻辑。
 */
public class PreciseShardingTableAlgorithm implements PreciseShardingAlgorithm<Long> {

    /**
     * 学号sno按表数量取模，模为0分片到表student_0，模为1分片到表student_1,模为2分片到表student_2
     *
     * @param tableNames           所有表名的集合，本例为[student_0,student_1,student_2]
     * @param preciseShardingValue 精确分片值,其有三个final属性，String columnName（分片列名：本例为sno），
     *                             String logicTableName（逻辑表名：本例为student），
     *                             T value（分片列的值：本例为sno的值）
     * @return 表名
     */
    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<Long> preciseShardingValue) {

        Long mod = preciseShardingValue.getValue() % tableNames.size();

        for (String tableName : tableNames) {
            if (tableName.endsWith(String.valueOf(mod))) {
                return tableName;
            }
        }

        throw new UnsupportedOperationException();
    }
}
