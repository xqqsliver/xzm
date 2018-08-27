package com.xz.service.frame;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;


/**
 * 分表策略,按照年月
 */
public class ShardTables implements SingleKeyTableShardingAlgorithm<Integer> {

    public String doEqualSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {
        String tableStr=shardingValue.getValue()/50+"";
        for(String tableName:tableNames){
            if(tableName.endsWith(tableStr)){
                return tableName;
            }
        }
        return null;
    }

    public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(tableNames.size());
        String tableSuffix=shardingValue.getValue()/50+"";
        for(String tableName:tableNames){
            if(tableName.endsWith(tableSuffix)){
                result.add(tableName);
            }
        }
        return result;
    }

    public Collection<String> doBetweenSharding(Collection<String > tableNames, ShardingValue<Integer> shardingValue) {
        Collection<String> result=new LinkedHashSet<String>(tableNames.size());
        Range<Integer> range = shardingValue.getValueRange();
        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            String tableSuffix = i / 50 + "";
            for (String each : tableNames) {
                if (each.endsWith(tableSuffix)) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
