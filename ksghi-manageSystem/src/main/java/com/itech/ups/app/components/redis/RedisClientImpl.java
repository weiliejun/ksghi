package com.itech.ups.app.components.redis;

import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.base.application.domain.CurrentManager;
import org.apache.log4j.Logger;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * app，pc共享一个redis 弃用
 *
 * @author hasee
 */
@Service("redisClient")
public class RedisClientImpl implements RedisClient {
    // session过期时间
    private static final int OVERDATETIME = 30 * 60;
    // private ShardedJedis shardedJedis;
    @Resource
    JedisConnectionFactory jedisConnectionFactory;
    private Logger logger = Logger.getLogger(RedisClientImpl.class);
    // @Resource
    // private RedisDataSource redisDataSource;//非切片额客户端连接
    @Resource
    private ShardedJedisPool shardedJedisPool;

    // private Jedis jedis;
    // 构造函数，初始化redis连接池
    public RedisClientImpl() {
        // shardedJedis = getJedis();
    }

    public static void main(String[] args) {
        RedisClient cl = new RedisClientImpl();
        try {
            CurrentManager manager = new CurrentManager();
            byte[] bt = cl.convertObjectToByte(manager);
            System.out.println(cl.convertObjectToByte(manager));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void flushDB() {
        Jedis jedis = getJedis();
        jedis = getJedis();
        jedis.flushDB();
        jedis.flushAll();
    }

    /**
     * 设置失效时间
     *
     * @param groupId
     * @param time
     */
    public void expire(String key, Integer time) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            if (time == null) {// app无需设置
            } else {
                if (time == 0) {
                    time = 1728000000;// 默认
                }
                if (shardedJedis.exists(key)) {
                    shardedJedis.expire(key, time);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
    }

    public void expireAt(String key, Integer time) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            if (time == null) {// app无需设置
            } else {
                if (time == 0) {
                    time = 1728000000;// 默认
                }
                if (shardedJedis.exists(key)) {
                    shardedJedis.expireAt(key, time);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            // returnResource(shardedJedis, broken);
            if (shardedJedis != null)
                shardedJedis.close();
        }
    }

    /**
     * 查询key的过期时间
     *
     * @param String key
     * @return 以秒为单位的时间表示
     */
    public long ttl(String key) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            if (shardedJedis.exists(key)) {
                long len = shardedJedis.ttl(key);
                return len;
            }
        } catch (Exception e) {
            e.printStackTrace();
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return -2;
    }

    public void disconnect() {
        ShardedJedis shardedJedis = getShardJedis();
        shardedJedis.disconnect();
    }

    /**
     * 设置某个set key
     *
     * @param key
     * @param value
     */
    public void SetStringOperate(String key, Object value, Integer keyTime) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            // shardedJedis.set(key,"dddd");
            shardedJedis.set(key.getBytes(), convertObjectToByte(value));
            expire(key, keyTime);
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
    }

    public Object getStringOperate(String key) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            return shardedJedis.get(key) != null ? convertByteToObject(shardedJedis.get(key.getBytes())) : null;
        } catch (Exception e) {
            broken = true;
            e.printStackTrace();
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return null;
    }

    /**
     * 删除某个set key
     *
     * @param key
     */
    public void delStringOperate(String key) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            shardedJedis.del(key);
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
    }

    /**
     * 获取所有setvalue
     *
     * @param key
     * @return
     */
    public boolean validStringOperateKey(String key) {
        ShardedJedis shardedJedis = getShardJedis();
        List<Object> result = null;
        boolean broken = false;
        try {
            if (key != null) {
                return shardedJedis.exists(key);
            }
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return broken;
    }

    /**
     * 存放某个组下面的key，value到redis
     *
     * @param groupId 系统分组
     * @param key键
     * @param value值
     */
    public void setHashOperate(String groupId, String key, Object value) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            shardedJedis.hset(groupId.getBytes(), key.getBytes(), convertObjectToByte(value));
            expire(key, 0);
            // ttl(groupId);
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
    }

    /**
     * 获取某个组中key的value
     *
     * @param groupId
     * @param key
     * @return
     */
    public Object getHashOperate(String groupId, String key) {
        ShardedJedis shardedJedis = getShardJedis();
        // shardedJedis.ttl(ApplicationSessionKeys.CURRENT_USER_PC);
        boolean broken = false;
        try {
            return convertByteToObject(shardedJedis.hget(groupId.getBytes(), key.getBytes()));
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return null;
    }
    // 注销redis链接
    // public void flushDB(){
    // jedis.flushDB();
    // }
    // public void destroy(){
    // jedisPool.destroy();
    // }

    /**
     * 删除某个族中key的value
     *
     * @param groupId
     * @param key
     */
    public void delHashOperate(String groupId, String key) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            if (validHashKeyOperate(groupId, key))
                shardedJedis.hdel(groupId, key);
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
    }

    /**
     * 获取hashs中的所有key
     *
     * @param groupId
     * @return
     */
    public List<Object> getAllHashValueOperate(String groupId) {
        ShardedJedis shardedJedis = getShardJedis();
        List<Object> result = null;
        boolean broken = false;
        try {
            if (groupId != null) {
                Collection<byte[]> object = shardedJedis.hvals(groupId.getBytes());
                if (object != null) {
                    result = new ArrayList<Object>();
                    for (byte[] obj : object) {
                        result.add(convertByteToObject(obj));
                    }
                }
            }
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return result;
    }

    /**
     * 获取hashs中的所有值
     *
     * @param groupId
     * @return
     */
    public Set<String> getAllHashKeyOperate(String groupId) {
        boolean broken = false;
        ShardedJedis shardedJedis = getShardJedis();
        try {
            return shardedJedis.hkeys(groupId);
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return null;
    }

    /**
     * 清空缓存
     *
     * @param groupId
     * @return
     */
    public Long removeAllHashOperate(String groupId) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            // Set<String> set = shardedJedis.hkeys(groupId);
            return shardedJedis.del(groupId);
            // while(set.iterator()!=null && set.iterator().hasNext()){
            // shardedJedis.delHashOperate(groupId,set.iterator().next());
            // }
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return null;
    }

    /**
     * 判断key是否存在
     *
     * @param groupId
     * @param key
     * @return
     */
    public boolean validHashKeyOperate(String key, String userId) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            CurrentManager manager = (CurrentManager) getStringOperate(key);
            if (manager != null && manager.getManager().getId().equals(userId))
                return true;
            // return shardedJedis.hexists(groupId.getBytes(), CurrentManager);
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return broken;
    }

    /**
     * 剔除上一个用户
     *
     * @param groupId
     * @param key
     */
    public void delManagerInfoById(String groupId, String userId) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            Set<String> obj = getAllHashKeyOperate(groupId);
            if (obj != null && obj.size() > 0) {
                for (String key : obj) {
                    CurrentManager manager = (CurrentManager) getHashOperate(groupId, key);
                    if (userId.equals(manager.getManager().getId())) {
                        delHashOperate(groupId, key);
                    }
                }
            }
        } catch (Exception e) {
            broken = false;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
    }

    /**
     * 判断用户是否存在
     */
    public boolean validManagerInfo(String groupId, String userId) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean broken = false;
        try {
            List<Object> obj = getAllHashValueOperate(groupId);
            if (obj != null && obj.size() > 0) {
                for (int i = 0; i < obj.size(); i++) {
                    CurrentManager manager = (CurrentManager) obj.get(i);
                    if (manager.getManager().getId().equals(userId)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            broken = false;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return broken;
    }

    /**
     * 批量获取key001和key003对应的值：
     *
     * @param groupId
     * @param key
     * @return
     */
    public List<Object> getBatchHashOperate(String groupId, String... key) {
        ShardedJedis shardedJedis = getShardJedis();
        List<Object> result = null;
        boolean broken = false;
        try {
            if (key != null) {
                List<byte[]> object = shardedJedis.hmget(groupId.getBytes(), key.toString().getBytes());
                if (object != null) {
                    result = new ArrayList<Object>();
                    for (byte[] obj : object) {
                        result.add(convertByteToObject(obj));
                    }
                }
            }
        } catch (Exception e) {
            broken = true;
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return result;
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

    }

    /**
     * 获取一个jedis 客户端
     *
     * @return
     */
    public Jedis getJedis() {
        Jedis jedis = null;
        try {
            jedis = jedisConnectionFactory.getShardInfo().createResource();
        } catch (Exception e) {
            if (null != jedis)
                jedis.close();
        }
        return jedis;
    }

    public ShardedJedis getShardJedis() {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
        } catch (Exception e) {
            if (null != shardedJedis)
                shardedJedis.close();
        }
        return shardedJedis;
    }

    // ----------------------redis登陆、登出等操作---------------------

    /**
     * 登录
     *
     * @return
     */
    @Override
    public void login(String sid, CurrentManager CurrentManager) {
        Manager manager = CurrentManager.getManager();
        String uid = manager.getId();
        // String appType = CurrentManager.getAppType();
        ShardedJedis shardedJedis = getShardJedis();
        try {
            // if ("android".equals(appType) || "ios".equals(appType)) {
            // shardedJedis.set(sid.getBytes(),
            // convertObjectToByte(CurrentManager));
            // shardedJedis.set(uid.getBytes(), convertObjectToByte(sid));
            // } else {
            shardedJedis.set(sid.getBytes(), convertObjectToByte(CurrentManager));
            expire(sid, OVERDATETIME);
            shardedJedis.set(uid.getBytes(), convertObjectToByte(sid));
            expire(uid, OVERDATETIME);
            // }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户：" + uid + "登录时，redis保存用户信息发生异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }

    }

    /**
     * 登出
     *
     * @return
     */
    @Override
    public void loginOut(String sid, String uid) {
        ShardedJedis shardedJedis = getShardJedis();
        try {
            shardedJedis.del(sid.getBytes());
            shardedJedis.del(uid.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户：" + uid + "下线时，redis保存用户信息发生异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
    }

    /**
     * 是指定的用户下线
     *
     * @return
     */
    @Override
    public void loginOut(String uid) {

        ShardedJedis shardedJedis = getShardJedis();
        try {
            Object obj = shardedJedis.get(uid.getBytes());
            if (obj != null) {
                String sidKey = convertByteToObject(shardedJedis.get(uid.getBytes())).toString();
                shardedJedis.del(sidKey.getBytes());
                shardedJedis.del(uid.getBytes());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户：" + uid + "下线时，redis保存用户信息发生异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
    }

    /**
     * 根据sessionId获取CurrentManager
     *
     * @return
     */
    @Override
    public CurrentManager getCurrentManagerBySid(String sid) {
        ShardedJedis shardedJedis = getShardJedis();
        CurrentManager CurrentManager = null;
        try {
            Object obj = shardedJedis.get(sid.getBytes()) != null ? convertByteToObject(shardedJedis.get(sid.getBytes())) : null;
            CurrentManager = (CurrentManager) obj;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis获取session：" + sid + "信息发生异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return CurrentManager;
    }

    /**
     * 根据userId获取CurrentManager
     *
     * @return
     */
    @Override
    public CurrentManager getCurrentManagerByUid(String uid) {
        ShardedJedis shardedJedis = getShardJedis();
        CurrentManager CurrentManager = null;
        try {
            Object keyObj = shardedJedis.get(uid.getBytes());
            if (keyObj != null) {
                String sidKey = convertByteToObject(shardedJedis.get(uid.getBytes())).toString();
                Object obj = shardedJedis.get(sidKey.getBytes()) != null ? convertByteToObject(shardedJedis.get(sidKey.getBytes())) : null;
                CurrentManager = (CurrentManager) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("redis获取用户：" + uid + "信息发生异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return CurrentManager;
    }

    /**
     * 根据userId获取修改CurrentManager
     *
     * @return
     */
    @Override
    public CurrentManager eidtCurrentManagerByUid(String uid, Manager manager) {
        ShardedJedis shardedJedis = getShardJedis();
        CurrentManager CurrentManager = null;
        try {
            Object keyObj = shardedJedis.get(uid.getBytes());
            if (keyObj != null) {
                String sidKey = convertByteToObject(shardedJedis.get(uid.getBytes())).toString();
                Object obj = shardedJedis.get(sidKey.getBytes()) != null ? convertByteToObject(shardedJedis.get(sidKey.getBytes())) : null;
                CurrentManager = (CurrentManager) obj;
                if (CurrentManager != null) {
                    CurrentManager.setManager(manager);
                    shardedJedis.set(sidKey.getBytes(), convertObjectToByte(CurrentManager));// 修改session的值
                    long len = shardedJedis.ttl(sidKey.getBytes());
                    if (len > 0) {// 没有过期
                        // set方法会导致有效时间失效，需要重新设置
                        shardedJedis.expire(sidKey.getBytes(), (int) len - 1);// 允许session失效有1秒的误差
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改redis中用户信息发生异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return CurrentManager;
    }

    /**
     * 指定用户是否在线
     *
     * @return
     */
    @Override
    public boolean isOnline(String uid) {
        ShardedJedis shardedJedis = getShardJedis();
        boolean isOnline = false;
        try {
            isOnline = shardedJedis.exists(uid.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("判断用户：" + uid + "是否在线发生异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return isOnline;
    }

    @Override
    public boolean isOnline(String sid, String uid) {
        ShardedJedis shardedJedis = getShardJedis();
        String sidKey = "";
        try {
            Object keyObj = shardedJedis.get(uid.getBytes());
            if (keyObj != null) {
                sidKey = convertByteToObject(shardedJedis.get(uid.getBytes())).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("判断用户：" + uid + "是否在线发生异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return sidKey.equals(sid);
    }
    // ----------------------redis登陆、登出等操作---------------------


    @Override
    public void lpush(byte[] key, byte[] value) {
        ShardedJedis shardedJedis = getShardJedis();
        try {
            shardedJedis.lpush(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("REDIS队列【顺序入队】操作异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }

    }

    @Override
    public void rpush(byte[] key, byte[] value) {
        ShardedJedis shardedJedis = getShardJedis();
        try {
            shardedJedis.rpush(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("REDIS队列【反序入队】操作异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }

    }


    @Override
    public List<byte[]> lpopList(byte[] key) {
        List<byte[]> list = null;
        ShardedJedis shardedJedis = getShardJedis();
        try {
            list = shardedJedis.lrange(key, 0, -1);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("REDIS队列【获取队列数据】操作异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return list;
    }

    @Override
    public byte[] rpop(byte[] key) {
        byte[] bytes = null;
        ShardedJedis shardedJedis = getShardJedis();
        bytes = shardedJedis.rpop(key);
        try {
            bytes = shardedJedis.rpop(key);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("REDIS队列【获取队列数据】操作异常：" + e.getMessage());
        } finally {
            if (shardedJedis != null)
                shardedJedis.close();
        }
        return bytes;
    }

    @Override
    public void publish(String channel, String message) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.publish(channel, message);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("REDIS【发布消息】操作异常：" + e.getMessage());
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }
}