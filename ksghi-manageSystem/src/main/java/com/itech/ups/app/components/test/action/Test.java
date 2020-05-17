package com.itech.ups.app.components.test.action;

import com.itech.ups.app.components.integra.IntegraService;
import com.itech.ups.app.components.integra.IntegraType;
import com.itech.ups.app.components.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 组件测试接口
 *
 * @author zhaoqingshan
 */
@Controller
public class Test {
    @Autowired
    private MessageSender messageSender;

    @RequestMapping(value = {"/integra/test"}, method = RequestMethod.GET)
    public String guide(HttpServletRequest request, Model model) {

        long getPayIntegra = IntegraService.getPayIntegra("invitedInitInvest", null);
        boolean integraResult = IntegraService.sendIntegra("20140514153120982772", IntegraType.incoming, "invitedInitInvest", "20140514153120982772", "受邀用户首次出借成功，奖励：" + getPayIntegra + "微积分", null);
        System.out.println(integraResult);
        return null;
    }

    @RequestMapping(value = {"/message/test"}, method = RequestMethod.GET)
    public String security(HttpServletRequest request, Model model) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("nickName", "春节");
        params.put("logoPath", "http://www.baidu.com");
        params.put("indexUrl", "http://www.baidu.com");
        // params.put("date", DateHelper.getYMDFormatDate());
        params.put("date", "5月4日");
        params.put("busiPriv", "111111");
        // emailMessageSend("201404012220545433674850", "holiday",
        // "470101439@qq.com", params);
        // mobileMessageSend("201404012220545433674850", "birthday",
        // "15817335895", params);
        // mobileMessageSend("201404012220545433674850", "birthday",
        // "13910778736", params);
        // mobileMessageSend("201404012220545433674850", "birthday",
        // "13910008973", params);
        // messageSender.mobileMessageSend("201404012220545433674850",
        // "birthday", "13121198112", params);

        StringBuilder content = new StringBuilder();
        content.append("<table border=\"1\">");
        content.append("<tr>");
        content.append("<td>结果描述</td>");
        content.append("<td>用户数</td>");
        content.append("<td>用户数据</td>");
        content.append("</tr>");
        content.append("<tr>");
        content.append("<td>总同步用户</td>");
        content.append("<td>1111111</td>");
        content.append("<td>&nbsp;</td>");
        content.append("</tr>");
        content.append("<tr>");
        content.append("<td>账户数据重复的用户</td>");
        content.append("<td>2222222</td>");
        content.append("<td>2222211111111111</td>");
        content.append("</tr>");
        content.append("<tr>");
        content.append("<td>同步失败用户</td>");
        content.append("<td>3333333333333</td>");
        content.append("<td>3333333333311111</td>");
        content.append("</tr>");
        content.append("<tr>");
        content.append("<td>账户余额不等用户</td>");
        content.append("<td>44444444</td>");
        content.append("<td>4444441111111111</td>");
        content.append("</tr>");
        content.append("</table>");

        messageSender.emailMessageSend(new String[]{"huangchang@ksfortune.com"}, "测试", content.toString());

        return null;
    }
}