package com.baidu.yun.push.sample;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.QueryTimerRecordsRequest;
import com.baidu.yun.push.model.QueryTimerRecordsResponse;
import com.baidu.yun.push.model.Record;

import java.util.List;

public class QueryTimerRecords {
    public static void main(String[] args) throws PushClientException, PushServerException {
        // 1. get apiKey and secretKey from developer console
        String apiKey = "xxxxxxxxxxxxxxxxxxxx";
        String secretKey = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

        // 2. build a BaidupushClient object to access released interfaces
        BaiduPushClient pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);

        // 3. register a YunLogHandler to get detail interacting information
        // in this request.
        pushClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });

        try {
            // 4. specify request arguments
            QueryTimerRecordsRequest request = new QueryTimerRecordsRequest().addTimerId("xxxxxxxxxxxx").addStart(0).// 设置索引起始位置
                    addLimit(10).// 设置查询记录条数
                    // addRangeStart(new Long(xxxxxxxx)).//设置查询开始时间
                    // addRangeEnd(System.currentTimeMillis() / 1000).//设置查询结束时间
                            addDeviceType(3);
            // 5. http request
            QueryTimerRecordsResponse response = pushClient.queryTimerRecords(request);
            // Http请求结果解析打印
            System.out.println("timerId: " + response.getTimerId() + "\nresult: ");
            if (null != response) {
                List<?> list = response.getTimerRecords();
                for (int i = 0; i < list.size(); i++) {
                    Object object = list.get(i);
                    if (object instanceof Record) {
                        Record record = (Record) object;
                        StringBuilder strBuilder = new StringBuilder();
                        strBuilder.append("List[" + i + "]: {" + "msgId = " + record.getMsgId() + ",status = " + record.getMsgStatus() + ",sendTime = " + record.getSendTime() + "}");
                        System.out.println(strBuilder.toString());
                    }
                }
            }
        } catch (PushClientException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw e;
            } else {
                e.printStackTrace();
            }
        } catch (PushServerException e) {
            if (BaiduPushConstants.ERROROPTTYPE) {
                throw e;
            } else {
                System.out.println(String.format("requestId: %d, errorCode: %d, errorMessage: %s", e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
            }
        }
    }
}
