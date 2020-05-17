package com.itech.ups.app.operation.application.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 徐赛平
 * @version 1.0
 * @description 发送短信错误码以及所对应的错误信息
 * @update 2018年1月9日 上午10:00:38
 */
public class SmsClientCode {
    private static Map<Integer, String> errorCodeMap = new HashMap<Integer, String>();

    public static Map<Integer, String> getErrorCodeMap() {
        errorCodeMap.put(0, "成功");
        errorCodeMap.put(-1, "系统异常");
        errorCodeMap.put(-2, "客户端异常");
        errorCodeMap.put(-101, "命令不被支持");
        errorCodeMap.put(-102, "RegistryTransInfo删除信息失败");
        errorCodeMap.put(-103, "RegistryInfo更新信息失败");
        errorCodeMap.put(-104, "请求超过限制");
        errorCodeMap.put(-110, "号码注册激活失败");
        errorCodeMap.put(-111, "企业注册失败");
        errorCodeMap.put(-113, "充值失败");
        errorCodeMap.put(-117, "发送短信失败");
        errorCodeMap.put(-118, "接收MO失败");
        errorCodeMap.put(-119, "接收Report失败");
        errorCodeMap.put(-120, "修改密码失败");
        errorCodeMap.put(-122, "号码注销激活失败");
        errorCodeMap.put(-123, "查询单价失败");
        errorCodeMap.put(-124, "查询余额失败");
        errorCodeMap.put(-125, "设置MO转发失败");
        errorCodeMap.put(-126, "路由信息失败");
        errorCodeMap.put(-127, "计费失败0余额");
        errorCodeMap.put(-128, "计费失败余额不足");
        errorCodeMap.put(-190, "数据操作失败");
        errorCodeMap.put(-1100, "序列号错误,序列号不存在内存中,或尝试攻击的用户");
        errorCodeMap.put(-1102, "序列号密码错误");
        errorCodeMap.put(-1103, "序列号Key错误");
        errorCodeMap.put(-1104, "路由失败，请联系系统管理员");
        errorCodeMap.put(-1105, "注册号状态异常, 未用 1");
        errorCodeMap.put(-1107, "注册号状态异常, 停用 3");
        errorCodeMap.put(-1108, "注册号状态异常, 停止 5");
        errorCodeMap.put(-1131, "充值卡无效");
        errorCodeMap.put(-1132, "充值密码无效");
        errorCodeMap.put(-1133, "充值卡绑定异常");
        errorCodeMap.put(-1134, "充值状态无效");
        errorCodeMap.put(-1135, "充值金额无效");
        errorCodeMap.put(-1901, "数据库插入操作失败");
        errorCodeMap.put(-1902, "数据库更新操作失败");
        errorCodeMap.put(-1903, "数据库删除操作失败");
        errorCodeMap.put(-9000, "数据格式错误,数据超出数据库允许范围");
        errorCodeMap.put(-9001, "序列号格式错误");
        errorCodeMap.put(-9002, "密码格式错误");
        errorCodeMap.put(-9003, "客户端Key格式错误");
        errorCodeMap.put(-9004, "设置转发格式错误");
        errorCodeMap.put(-9005, "公司地址格式错误");
        errorCodeMap.put(-9006, "企业中文名格式错误");
        errorCodeMap.put(-9007, "企业中文名简称格式错误");
        errorCodeMap.put(-9008, "邮件地址格式错误");
        errorCodeMap.put(-9009, "企业英文名格式错误");
        errorCodeMap.put(-9010, "企业英文名简称格式错误");
        errorCodeMap.put(-9011, "传真格式错误");
        errorCodeMap.put(-9012, "联系人格式错误");
        errorCodeMap.put(-9013, "联系电话");
        errorCodeMap.put(-9014, "邮编格式错误");
        errorCodeMap.put(-9015, "新密码格式错误");
        errorCodeMap.put(-9016, "发送短信包大小超出范围");
        errorCodeMap.put(-9017, "发送短信内容格式错误");
        errorCodeMap.put(-9018, "发送短信扩展号格式错误");
        errorCodeMap.put(-9019, "发送短信优先级格式错误");
        errorCodeMap.put(-9020, "发送短信手机号格式错误");
        errorCodeMap.put(-9021, "发送短信定时时间格式错误");
        errorCodeMap.put(-9022, "发送短信唯一序列值错误");
        errorCodeMap.put(-9023, "充值卡号格式错误");
        errorCodeMap.put(-9024, "充值密码格式错误");
        errorCodeMap.put(-9025, "客户端请求sdk5超时");
        return errorCodeMap;
    }


}
