package com.itech.ups.app.components.message.wechat;

import com.itech.ups.app.components.message.exception.MessageSenderFailedException;
import com.itech.ups.app.components.redis.RedisClient;
import com.itech.ups.base.application.domain.TemplateMessage;
import com.itech.ups.base.constant.BusinessConstant;
import com.itech.ups.base.util.HttpConnectionManager;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class WechatClient {

    @Resource
    private RedisClient redisClient;

    public boolean sendTemplateMsg(TemplateMessage templateMessage) throws MessageSenderFailedException {
        // 获取token目前测试服务号
        String accessToken = (String) redisClient.getStringOperate(BusinessConstant.WECHAT_ACCESS_TOKEN);
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken;
        String jsonParam = templateMessage.toJsonString();
        HttpConnectionManager mana = new HttpConnectionManager();
        HttpClient httpClient = mana.getHttpClient();
        // httpClient.getParams().setParameter("http.socket.timeout", new
        // Integer(500000));
        HttpPost post = new HttpPost(url);
        HttpResponse response = null;
        try {
            ByteArrayEntity body = new ByteArrayEntity(jsonParam.getBytes("UTF-8"));
            post.setEntity(body);
            response = httpClient.execute(post);
            if (response.getStatusLine().getReasonPhrase().equals("OK") && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String resData = EntityUtils.toString(response.getEntity());
                JSONObject json = new JSONObject(resData);
                // 正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
                int code = json.getInt("errcode");
                if (code == 0) {
                } else {
                }
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return false;
    }

}