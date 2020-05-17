package com.itech.ups.app.components.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itech.ups.app.components.message.MessageSender;
import com.itech.ups.base.constant.BusinessConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 张可乐
 * @version 1.0
 * @description redis消息监听类，实现异步发短息功能
 * @update 2017-10-27 上午9:45:41
 */
@Component
public class RedisMsgPubSubListener extends JedisPubSub {

    @Autowired
    private MessageSender messageSender;
/*    @Override  
    public void unsubscribe() {  
        super.unsubscribe();  
    }  
  
    @Override  
    public void unsubscribe(String... channels) {  
        super.unsubscribe(channels);  
    }  
  
    @Override  
    public void subscribe(String... channels) {  
        super.subscribe(channels);  
    }  
  
    @Override  
    public void psubscribe(String... patterns) {  
        super.psubscribe(patterns);  
    }  
  
    @Override  
    public void punsubscribe() {  
        super.punsubscribe();  
    }  
  
    @Override  
    public void punsubscribe(String... patterns) {  
        super.punsubscribe(patterns);  
    } */

    @Override
    public void onMessage(String channel, String message) {
        JSONObject msgJson = JSON.parseObject(message);
        String userId = msgJson.getString(BusinessConstant.USERID);
        String busiMsgType = msgJson.getString(BusinessConstant.BUSI_MSG_TYPE);
        Map<String, String> msgMap = new HashMap<String, String>();
        Set<String> keysSet = msgJson.keySet();
        Iterator<String> iterator = keysSet.iterator();
        String key = null;
        while (iterator.hasNext()) {
            key = iterator.next();
            msgMap.put(key, msgJson.getString(key));
        }
        //发送消息
        messageSender.busiMessageSend(userId, busiMsgType, msgMap);
    }  
  
   /* @Override  
    public void onPMessage(String pattern, String channel, String message) {  
  
    }  
  
    @Override  
    public void onSubscribe(String channel, int subscribedChannels) {  
    	super.onSubscribe(channel, subscribedChannels);
    }  
  
    @Override  
    public void onPUnsubscribe(String pattern, int subscribedChannels) {  
  
    }  
  
    @Override  
    public void onPSubscribe(String pattern, int subscribedChannels) {  
  
    }  
  
    @Override  
    public void onUnsubscribe(String channel, int subscribedChannels) {  
    } */
}
