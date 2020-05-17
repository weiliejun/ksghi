package com.itech.ups.app.components.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

/**
 * redis基本类
 *
 * @author hasee
 */
public interface RedisDataSource {
    public abstract ShardedJedis getShardedRedisClient();

    public abstract Jedis getRedisClient();// 取得redis的客户端，可以执行命令了。

    public void returnResource(ShardedJedis shardedJedis);// 将资源返还给pool

    public void returnResource(ShardedJedis shardedJedis, boolean broken);// 出现异常后，将资源返还给pool
    // （其实不需要第二个方法）
}
