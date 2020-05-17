package com.itech.ups.app.components.redis;

import com.itech.ups.app.manager.application.domain.Manager;
import com.itech.ups.base.application.domain.CurrentManager;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * app，pc共享一个redis 弃用
 *
 * @author hasee
 */
public interface RedisClient {

    public void flushDB();
    /**
     * 设置失效时间
     *
     * @param groupId
     * @param time
     */
    ;

    /**
     * 查询key的过期时间
     *
     * @param String key
     * @return 以秒为单位的时间表示
     */
    public long ttl(String key);

    public void disconnect();

    public void expire(String key, Integer time);

    // 续期
    public void expireAt(String key, Integer time);

    /**
     * 设置某个set key
     *
     * @param key
     * @param value
     */
    public void SetStringOperate(String key, Object value, Integer keyTime);

    public Object getStringOperate(String key);

    /**
     * 删除某个set key
     *
     * @param key
     */
    public void delStringOperate(String key);

    /**
     * 获取所有setvalue
     *
     * @param key
     * @return
     */
    public boolean validStringOperateKey(String key);

    /**
     * 存放某个组下面的key，value到redis
     *
     * @param groupId 系统分组
     * @param key键
     * @param value值
     */
    public void setHashOperate(String groupId, String key, Object value);

    /**
     * 获取某个组中key的value
     *
     * @param groupId
     * @param key
     * @return
     */
    public Object getHashOperate(String groupId, String key);

    /**
     * 删除某个族中key的value
     *
     * @param groupId
     * @param key
     */
    public void delHashOperate(String groupId, String key);
    // 注销redis链接
    // public void flushDB(){
    // jedis.flushDB();
    // }
    // public void destroy(){
    // jedisPool.destroy();
    // }

    /**
     * 获取hashs中的所有key
     *
     * @param groupId
     * @return
     */
    public List<Object> getAllHashValueOperate(String groupId);

    /**
     * 获取hashs中的所有值
     *
     * @param groupId
     * @return
     */
    public Set<String> getAllHashKeyOperate(String groupId);

    /**
     * 清空缓存
     *
     * @param groupId
     * @return
     */
    public Long removeAllHashOperate(String groupId);

    /**
     * 判断key是否存在
     *
     * @param groupId
     * @param key
     * @return
     */
    public boolean validHashKeyOperate(String key, String userId);

    /**
     * 剔除上一个用户
     *
     * @param groupId
     * @param key
     */
    public void delManagerInfoById(String groupId, String userId);

    /**
     * 判断用户是否存在
     */
    public boolean validManagerInfo(String groupId, String userId);

    /**
     * 批量获取key001和key003对应的值：
     *
     * @param groupId
     * @param key
     * @return
     */
    public List<Object> getBatchHashOperate(String groupId, String... key);

    /**
     * 强制转换对象为byte字节
     *
     * @param obj
     * @return
     */
    public byte[] convertObjectToByte(Object obj);

    /**
     * 强制转换byte字节为对象
     *
     * @param bytes
     * @return
     */
    public Object convertByteToObject(byte[] bytes);

    /**
     * 获取一个jedis 客户端
     *
     * @return
     */
    public Jedis getJedis();

    /**
     * 登录
     *
     * @return
     */
    public void login(String sid, CurrentManager currentManager);

    /**
     * 登出
     *
     * @return
     */
    public void loginOut(String sid, String uid);

    /**
     * 是指定的用户下线
     *
     * @return
     */
    public void loginOut(String uid);

    /**
     * 根据sessionId获取CurrentManager
     *
     * @return
     */
    public CurrentManager getCurrentManagerBySid(String sid);

    /**
     * 根据userId获取CurrentManager
     *
     * @return
     */
    public CurrentManager getCurrentManagerByUid(String uid);

    /**
     * 根据userId获取修改CurrentManager
     *
     * @return
     */
    public CurrentManager eidtCurrentManagerByUid(String uid, Manager user);

    /**
     * 指定用户是否在线
     *
     * @return
     */
    public boolean isOnline(String uid);

    public boolean isOnline(String sid, String uid);


    /**
     * 存储REDIS队列 顺序存储
     */
    public void lpush(byte[] key, byte[] value);

    /**
     * 存储REDIS队列 反向存储
     */
    public void rpush(byte[] key, byte[] value);

    /**
     * 获取队列数据
     */
    public List<byte[]> lpopList(byte[] key);

    /**
     * 获取队列数据
     */
    public byte[] rpop(byte[] key);

    /**
     * redis向指定频道发布消息|
     */
    public void publish(String channel, String message);

}