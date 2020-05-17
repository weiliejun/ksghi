package com.itech.ups.app.components.redis;

import com.itech.ups.base.application.domain.CurrentManager;
import org.apache.log4j.Logger;
import redis.clients.jedis.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RedisClientOther {
    private static Logger logger = Logger.getLogger(RedisClientOther.class);
    private Jedis jedis;// 非切片额客户端连接
    private JedisPool jedisPool;// 非切片连接池
    private ShardedJedis shardedJedis;// 切片额客户端连接
    private ShardedJedisPool shardedJedisPool;// 切片连接池

    public RedisClientOther() {
        initialPool();
        initialShardedPool();
        shardedJedis = shardedJedisPool.getResource();
        jedis = jedisPool.getResource();
    }
    //

    /**
     * 序列化
     *
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            //
        }
        return null;
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            //
        }
        return null;
    }

    //
    public static void main(String[] args) {
        RedisClientOther client = new RedisClientOther();
        client.show();
        CurrentManager user = new CurrentManager();
        client.setStringOperate("dddd", user);
        client.set("dddd", "ddd");
        client.getObject();
        client.setStringOperate("11", user);
        logger.info(client.getStringOperate("11"));
    }

    /**
     * 初始化非切片池
     */
    private void initialPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config, "192.168.1.89", 6379);
    }

    /**
     * 初始化切片池
     */
    private void initialShardedPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);
        // slave链接
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("192.168.1.89", 6379, "master"));
        //
        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    //
    public void show() {
        KeyOperate();
        StringOperate2();
        ListOperate();
        SetOperate();
        SortedSetOperate();
        HashOperate();
        jedisPool.returnResource(jedis);
        shardedJedisPool.returnResource(shardedJedis);
    }

    //
    private void KeyOperate() {
    }

    //
    private void StringOperate() {
        logger.info("======================String_1==========================");
        // 清空数据
        logger.info("清空库中所有数据：" + jedis.flushDB());

        logger.info("=============增=============");
        jedis.set("key001", "value001");
        jedis.set("key002", "value002");
        jedis.set("key003", "value003");
        logger.info("已新增的3个键值对如下：");
        logger.info(jedis.get("key001"));
        logger.info(jedis.get("key002"));
        logger.info(jedis.get("key003"));

        logger.info("=============删=============");
        logger.info("删除key003键值对：" + jedis.del("key003"));
        logger.info("获取key003键对应的值：" + jedis.get("key003"));

        logger.info("=============改=============");
        // 1、直接覆盖原来的数据
        logger.info("直接覆盖key001原来的数据：" + jedis.set("key001", "value001-update"));
        logger.info("获取key001对应的新值：" + jedis.get("key001"));
        // 2、直接覆盖原来的数据
        logger.info("在key002原来值后面追加：" + jedis.append("key002", "+appendString"));
        logger.info("获取key002对应的新值" + jedis.get("key002"));

        logger.info("=============增，删，查（多个）=============");
        /**
         * mset,mget同时新增，修改，查询多个键值对 等价于： jedis.set("name","ssss");
         * jedis.set("jarorwar","xxxx");
         */
        logger.info("一次性新增key201,key202,key203,key204及其对应值：" + jedis.mset("key201", "value201", "key202", "value202", "key203", "value203", "key204", "value204"));
        logger.info("一次性获取key201,key202,key203,key204各自对应的值：" + jedis.mget("key201", "key202", "key203", "key204"));
        logger.info("一次性删除key201,key202：" + jedis.del(new String[]{"key201", "key202"}));
        logger.info("一次性获取key201,key202,key203,key204各自对应的值：" + jedis.mget("key201", "key202", "key203", "key204"));

        //
        logger.info("所有key" + jedis.keys("*"));
        // jedis具备的功能shardedJedis中也可直接使用，下面测试一些前面没用过的方法
        logger.info("======================String_2==========================");
        // 清空数据
        logger.info("清空库中所有数据：" + jedis.flushDB());

        logger.info("=============新增键值对时防止覆盖原先值=============");
        logger.info("原先key301不存在时，新增key301：" + shardedJedis.setnx("key301", "value301"));
        logger.info("原先key302不存在时，新增key302：" + shardedJedis.setnx("key302", "value302"));
        logger.info("当key302存在时，尝试新增key302：" + shardedJedis.setnx("key302", "value302_new"));
        logger.info("获取key301对应的值：" + shardedJedis.get("key301"));
        logger.info("获取key302对应的值：" + shardedJedis.get("key302"));

        logger.info("=============超过有效期键值对被删除=============");
        // 设置key的有效期，并存储数据
        logger.info("新增key303，并指定过期时间为2秒" + shardedJedis.setex("key303", 2, "key303-2second"));
        logger.info("获取key303对应的值：" + shardedJedis.get("key303"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        logger.info("3秒之后，获取key303对应的值：" + shardedJedis.get("key303"));

        logger.info("=============获取原值，更新为新值一步完成=============");
        logger.info("key302原值：" + shardedJedis.getSet("key302", "value302-after-getset"));
        logger.info("key302新值：" + shardedJedis.get("key302"));

        logger.info("=============获取子串=============");
        logger.info("获取key302对应值中的子串：" + shardedJedis.getrange("key302", 5, 7));

        logger.info("所有key" + jedis.keys("*"));
    }

    private void StringOperate2() {
        logger.info("======================String_1==========================");
        // 清空数据
        logger.info("清空库中所有数据：" + jedis.flushDB());

        logger.info("=============增=============");
        shardedJedis.set("key001", "value001");
        shardedJedis.set("key002", "value002");
        shardedJedis.set("key003", "value003");
        logger.info("已新增的3个键值对如下：");
        logger.info(shardedJedis.get("key001"));
        logger.info(shardedJedis.get("key002"));
        logger.info(shardedJedis.get("key003"));

        logger.info("=============删=============");
        logger.info("删除key003键值对：" + shardedJedis.del("key003"));
        logger.info("获取key003键对应的值：" + shardedJedis.get("key003"));

        logger.info("=============改=============");
        // 1、直接覆盖原来的数据
        logger.info("直接覆盖key001原来的数据：" + shardedJedis.set("key001", "value001-update"));
        logger.info("获取key001对应的新值：" + shardedJedis.get("key001"));
        // 2、直接覆盖原来的数据
        logger.info("在key002原来值后面追加：" + shardedJedis.append("key002", "+appendString"));
        logger.info("获取key002对应的新值" + shardedJedis.get("key002"));

        logger.info("=============增，删，查（多个）=============");

        //
        logger.info("所有key" + jedis.keys("*"));
        // jedis具备的功能shardedJedis中也可直接使用，下面测试一些前面没用过的方法
        logger.info("======================String_2==========================");
        // 清空数据
        logger.info("清空库中所有数据：" + jedis.flushDB());
        logger.info("所有key" + jedis.keys("*"));
        logger.info("=============新增键值对时防止覆盖原先值=============");
        logger.info("原先key301不存在时，新增key301：" + shardedJedis.setnx("key301", "value301"));
        logger.info("原先key302不存在时，新增key302：" + shardedJedis.setnx("key302", "value302"));
        logger.info("当key302存在时，尝试新增key302：" + shardedJedis.setnx("key302", "value302_new"));
        logger.info("获取key301对应的值：" + shardedJedis.get("key301"));
        logger.info("获取key302对应的值：" + shardedJedis.get("key302"));

        logger.info("=============超过有效期键值对被删除=============");
        // 设置key的有效期，并存储数据
        logger.info("新增key303，并指定过期时间为2秒" + shardedJedis.setex("key303", 2, "key303-2second"));
        logger.info("获取key303对应的值：" + shardedJedis.get("key303"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        logger.info("3秒之后，获取key303对应的值：" + shardedJedis.get("key303"));

        logger.info("=============获取原值，更新为新值一步完成=============");
        logger.info("key302原值：" + shardedJedis.getSet("key302", "value302-after-getset"));
        logger.info("key302新值：" + shardedJedis.get("key302"));

        logger.info("=============获取子串=============");
        logger.info("获取key302对应值中的子串：" + shardedJedis.getrange("key302", 5, 7));

        logger.info("所有key" + jedis.keys("*"));
    }

    private void ListOperate() {
    }

    //
    private void SetOperate() {
    }

    //
    private void SortedSetOperate() {
    }

    private void HashOperate() {
    }

    /**
     * 强制转换对象为byte字节
     *
     * @param obj
     * @return
     */
    public byte[] convertObjectToByte(Object obj) {
        if (obj != null) {
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(out);
                os.writeObject(obj);
                out.close();
                os.close();
                return out.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //

    /**
     * 强制转换byte字节为对象
     *
     * @param bytes
     * @return
     */
    public Object convertByteToObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
        //
    }

    public Object getStringOperate(String key) {
        boolean broken = false;
        try {
            return jedis.get(key) != null ? convertByteToObject(jedis.get(key.getBytes())) : null;
        } catch (Exception e) {
            broken = true;
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    /**
     * 设置某个set key
     *
     * @param key
     * @param value
     */
    public void setStringOperate(String key, Object value) {
        boolean broken = false;
        try {
            shardedJedis.set(key, "dddd");
            jedis.set(key.getBytes(), serialize(value));
        } catch (Exception e) {
            broken = true;
        } finally {

        }
    }

    public void setObject() {
        try {
            jedis.set("ddddd".getBytes(), serialize(new CurrentManager()));
            jedis.set("person:101".getBytes(), serialize(new CurrentManager()));
        } catch (Exception e) {
        } finally {
        }
    }
    //

    /**
     * 反序列化取对象, 用Jedis获取对象
     */
    public void getObject() {
        byte[] data100 = jedis.get(("person:100").getBytes());
        CurrentManager person100 = (CurrentManager) unserialize(data100);
        logger.info("person:100->id=%s,name=%s");

        byte[] data101 = jedis.get(("person:101").getBytes());
        CurrentManager person101 = (CurrentManager) unserialize(data101);
        logger.info("person:101->id=%s,name=%s");
    }
    //

    /**
     * 设置单个值
     *
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        String result = null;
        //
        if (jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = jedis.set(key, value);
        } catch (Exception e) {
            broken = true;
        } finally {
        }
        return result;
    }

    /**
     * 获取单个值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        String result = null;
        if (jedis == null) {
            return result;
        }
        //
        boolean broken = false;
        try {
            result = jedis.get(key);
            //
        } catch (Exception e) {
            broken = true;
        } finally {
        }
        return result;
    }
}