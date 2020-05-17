package com.itech.ups.app.components.crawler;

import com.itech.ups.app.product.application.domain.ProductFuturesData;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 执行抓取历史记录的action
 *
 * @author Administrator
 */
public class CrawlerData {

    private String httpUrl; // 登录url
    private String viewState;
    private String enventValidation;
    private String btnLogin_x;
    private String btnLogin_y;
    private String httpUlrDire;// 直接最终访问的url
    private String userName;
    private String passWord;
    public CrawlerData(String httpUrl, String viewState, String enventValidation, String btnLogin_x, String btnLogin_y, String httpUlrDire, String userName, String passWord) {
        this.httpUrl = httpUrl;
        this.viewState = viewState;
        this.enventValidation = enventValidation;
        this.btnLogin_x = btnLogin_x;
        this.btnLogin_y = btnLogin_y;
        this.httpUlrDire = httpUlrDire;
        this.userName = userName;
        this.passWord = passWord;

    }

    public static void main(String[] args) throws Exception {
        /*
         * Parser parser = null;
         *
         * HttpClient client = new HttpClient();
         *
         * //模拟登录页面 PostMethod post = new
         * PostMethod("http://180.168.102.226:23175/Default.aspx");
         * NameValuePair __VIEWSTATE = new NameValuePair("__VIEWSTATE",
         * "/wEPDwUKMTkwNzYwMDM2M2QYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgIFDEltYWdlQnV0dG9uMQUMSW1hZ2VCdXR0b24yWTRR6D79srRYUI9woP+PFKmqMb4="
         * ); NameValuePair __EVENTVALIDATION = new
         * NameValuePair("__EVENTVALIDATION",
         * "/wEWBQK65/rVDAKSwMX5DgKn8OewAgLSwpnTCALSwtXkAtywioLlx9phrYH0dN3ZZxAG6hAA"
         * ); NameValuePair RohonLoginUserName = new
         * NameValuePair("RohonLoginUserName", "BJ8010263"); NameValuePair
         * RohonLoginPassword= new NameValuePair("RohonLoginPassword",
         * "123456"); NameValuePair btnLoginx = new
         * NameValuePair("ImageButton1.x", "33"); NameValuePair btnLoginy = new
         * NameValuePair("ImageButton1.y", "18"); post.setRequestBody(new
         * NameValuePair []{__VIEWSTATE,__EVENTVALIDATION,RohonLoginUserName,
         * RohonLoginPassword ,btnLoginx,btnLoginy}); int status =
         * client.executeMethod(post); ProductFuturesData data =new
         * ProductFuturesData(); post.releaseConnection(); //查看cookie信息
         * CookieSpec cookiespec = CookiePolicy.getDefaultSpec(); Cookie[]
         * cookies = client.getState().getCookies(); if (cookies.length == 0) {
         * System.out.println("None"); } else { for (int i = 0; i <
         * cookies.length; i++) { System.out.println(cookies[i].toString()); } }
         *
         * //访问所需的页面 GetMethod get = new GetMethod(
         * "http://180.168.102.226:23175/web/custome/BenefitDaily.aspx?force=1&keyword=1001&key=2015-06-18&page=undefined"
         * ); client.executeMethod(get); // visitor = new
         * ObjectFindingVisitor(TableTag.class); parser = new Parser();
         * parser.setInputHTML(get.getResponseBodyAsString());
         * parser.setEncoding("GBK"); parser.visitAllNodesWith(visitor);
         *
         *
         * StringBuffer text = new StringBuffer(); parser =
         * Parser.createParser(new
         * String(get.getResponseBodyAsString().getBytes(),"utf-8"), "utf-8");
         * // 遍历所有的节点 NodeList nodes = parser.extractAllNodesThatMatch(new
         * NodeFilter() { public boolean accept(Node node) { return true; } });
         *
         * System.out.println(nodes.size()); //打印节点的数量 for (int
         * i=0;i<nodes.size();i++){ Node nodet = nodes.elementAt(i);
         *
         * // System.out.println(nodet.getText()); // System.out.println(new
         * String(nodet.toPlainTextString().getBytes("utf-8"))+"\r\n");
         * text.append(new
         * String(nodet.toPlainTextString().getBytes("utf-8"))+"\r\n"); //
         * Map<String,String>futureDataMap=new HashMap<String ,String>();
         *
         * NodeFilter filter_title = new TagNameFilter("div");//title节点过滤
         * NodeList nodelist = parser.parse(filter_title); Node nodes[] =
         * nodelist.toNodeArray(); for(int i=0 ;i<nodes.length;i++) {
         *
         * if(nodes[i].getText().equals(
         * "div align=\"center\" class=\"STYLE2 STYLE1\" style=\"text-align: left; padding-left: 20px;\""
         * )) { // System.out.println(new
         * String(nodes[i].toPlainTextString().getBytes("utf-8"))); String
         * dataValue= new
         * String(nodes[i+1].toPlainTextString().getBytes("utf-8")); String
         * tempa=""; String tempb=""; if(dataValue!=null) { tempa=new
         * String(nodes
         * [i+1].toPlainTextString().getBytes("utf-8")).split("\\r\\n")[1];
         * tempb=tempa.trim(); } if((new String
         * (nodes[i].toPlainTextString().getBytes
         * ("utf-8")).contains("账户"))&&nodes
         * [i+1].getText().equals("div align=\"center\" class=\"STYLE2 STYLE1\""
         * )) { data.setTradingAccountNo(tempb);
         *
         * } else if((new String
         * (nodes[i].toPlainTextString().getBytes("utf-8"))
         * .contains("交易日期"))&&nodes
         * [i+1].getText().equals("div align=\"center\" class=\"STYLE2 STYLE1\""
         * )){ data.setWorthDate(tempb); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("客户名称"))&&nodes
         * [i+1].getText().equals("div align=\"center\" class=\"STYLE2 STYLE1\""
         * )){ data.setCustomerName(tempb); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("上日结存"))&&nodes[i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setYesterdayBalance(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("客户权益"))&&nodes[i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setCustomerEquity(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("当日存取合计"))&&
         * nodes[i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setTodayTotalAccess(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("质押金"))&&nodes[i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setQualityDeposit(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("当日盈亏"))&&nodes[i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setDayProfitAndLoss(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("保证金占用"))&&nodes
         * [i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setMarginOccupancy(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("当日手续费"))&&nodes
         * [i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setDayFee(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("可用资金"))&&nodes[i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setAvailableFunds(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("当日结存"))&&nodes[i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setTodayBalance(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("风险度"))&&nodes[i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setRiskDegree(new
         * BigDecimal(tempb.replace(",", ""))); } else if((new String
         * (nodes[i].toPlainTextString
         * ().getBytes("utf-8")).contains("追加保证金"))&&nodes
         * [i+1].getText().equals(
         * "div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\""
         * )){ if(!"".equals(tempb)) data.setAdditionalBond(new
         * BigDecimal(tempb.replace(",", ""))); } }
         *
         *
         * } if(new String ("无标题文档".getBytes("utf-8")).equals(new String
         * (nodet.toPlainTextString().getBytes("utf-8")))){
         * System.out.println("123"); System.out.print(new String
         * (nodet.toPlainTextString().getBytes("utf-8"))); } }
         * //System.out.println(text.toString()); //取得要解析的页面数 Node[] tables =
         * visitor.getTags(); TableTag tableTag = (TableTag)
         * tables[tables.length-1]; TableRow[] rows = tableTag.getRows();
         * TableRow row = rows[0]; TableColumn[] col = row.getColumns(); int
         * pageNumber = Integer.parseInt(col[0].getChildrenHTML().substring(25,
         * 29)); get.releaseConnection();
         *
         * for(int i=1;i<pageNumber;i++){ PostMethod pt = new
         * PostMethod("http://211.90.119.58:9999/PhoneSearch/PhoneSearch.aspx");
         * NameValuePair txtPage = new
         * NameValuePair("txtPage",Integer.toString(i)); __VIEWSTATE = new
         * NameValuePair("__VIEWSTATE", ""); NameValuePair __EVENTTARGET = new
         * NameValuePair("__EVENTTARGET", ""); NameValuePair __EVENTARGUMENT =
         * new NameValuePair("__EVENTARGUMENT", ""); NameValuePair TBMDN = new
         * NameValuePair("TBMDN", ""); NameValuePair TBServiceType = new
         * NameValuePair("TBServiceType", ""); NameValuePair TBStartTime = new
         * NameValuePair("TBStartTime", ""); NameValuePair TBEndTime = new
         * NameValuePair("TBEndTime", ""); NameValuePair btnGotox = new
         * NameValuePair("btnGoto.x", "26"); NameValuePair btnGotoy = new
         * NameValuePair("btnGoto.y", "13"); pt.setRequestBody(new
         * NameValuePair[
         * ]{__EVENTTARGET,__EVENTARGUMENT,__VIEWSTATE,TBMDN,TBServiceType
         * ,TBStartTime,TBEndTime,txtPage,btnGotox,btnGotoy}); int a =
         * client.executeMethod(pt);
         *
         *
         * parser.setInputHTML(pt.getResponseBodyAsString());
         * parser.setEncoding("GBK"); parser.visitAllNodesWith(visitor);
         *
         * tables = visitor.getTags(); tableTag = (TableTag)
         * tables[tables.length-3];
         *
         * rows = tableTag.getRows(); row = rows[1]; col = row.getColumns();
         * System.out.println(col[4].getChildrenHTML().toString());
         * get.releaseConnection(); }
         */
        ProductFuturesData d;
        CrawlerData crawler = new CrawlerData("http://180.168.102.226:23175/Default.aspx", "/wEPDwUKMTkwNzYwMDM2M2QYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgIFDEltYWdlQnV0dG9uMQUMSW1hZ2VCdXR0b24yWTRR6D79srRYUI9woP+PFKmqMb4=", "/wEWBQK65/rVDAKSwMX5DgKn8OewAgLSwpnTCALSwtXkAtywioLlx9phrYH0dN3ZZxAG6hAA", "33", "18", "http://180.168.102.226:23175/web/custome/BenefitDaily.aspx?force=1&keyword=1001&key=2015-06-17&page=undefined", "BJ8010263", "123456");
        d = crawler.crawler();
        System.out.println("123");
    }

    public ProductFuturesData crawler() throws HttpException, IOException, ParserException {
        Parser parser = null;

        HttpClient client = new HttpClient();

        // 模拟登录页面
        PostMethod post = new PostMethod(httpUrl);
        NameValuePair __VIEWSTATE = new NameValuePair("__VIEWSTATE", viewState);
        NameValuePair __EVENTVALIDATION = new NameValuePair("__EVENTVALIDATION", enventValidation);
        NameValuePair RohonLoginUserName = new NameValuePair("RohonLoginUserName", userName);
        NameValuePair RohonLoginPassword = new NameValuePair("RohonLoginPassword", passWord);
        NameValuePair btnLoginx = new NameValuePair("ImageButton1.x", btnLogin_x);
        NameValuePair btnLoginy = new NameValuePair("ImageButton1.y", btnLogin_y);
        post.setRequestBody(new NameValuePair[]{__VIEWSTATE, __EVENTVALIDATION, RohonLoginUserName, RohonLoginPassword, btnLoginx, btnLoginy});
        int status = client.executeMethod(post);
        ProductFuturesData data = new ProductFuturesData();
        post.releaseConnection();
        // 查看cookie信息
        CookieSpec cookiespec = CookiePolicy.getDefaultSpec();
        Cookie[] cookies = client.getState().getCookies();
        if (cookies.length == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < cookies.length; i++) {
                System.out.println(cookies[i].toString());
            }
        }

        // 访问所需的页面
        GetMethod get = new GetMethod(httpUlrDire);
        client.executeMethod(get);

        StringBuffer text = new StringBuffer();
        parser = Parser.createParser(new String(get.getResponseBodyAsString().getBytes(), "utf-8"), "utf-8");

        NodeFilter filter_title = new TagNameFilter("div");// title节点过滤
        NodeList nodelist = parser.parse(filter_title);
        Node nodes[] = nodelist.toNodeArray();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getText().equals("div align=\"center\" class=\"STYLE2 STYLE1\" style=\"text-align: left; padding-left: 20px;\"")) {
                // System.out.println(new
                // String(nodes[i].toPlainTextString().getBytes("utf-8")));
                String dataValue = new String(nodes[i + 1].toPlainTextString().getBytes("utf-8"));
                String tempa = "";
                String tempb = "";
                if (dataValue != null) {
                    tempa = new String(nodes[i + 1].toPlainTextString().getBytes("utf-8")).split("\\r\\n")[1];
                    tempb = tempa.trim();
                }
                if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("账户")) && nodes[i + 1].getText().equals("div align=\"center\" class=\"STYLE2 STYLE1\"")) {
                    data.setTradingAccountNo(tempb);

                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("交易日期")) && nodes[i + 1].getText().equals("div align=\"center\" class=\"STYLE2 STYLE1\"")) {
                    if (tempb.indexOf("年") != -1)
                        data.setWorthDate(tempb.replace("年", "-").replace("月", "-").replace("日", ""));
                    else
                        data.setWorthDate(null);
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("客户名称")) && nodes[i + 1].getText().equals("div align=\"center\" class=\"STYLE2 STYLE1\"")) {
                    data.setCustomerName(tempb);
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("上日结存")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setYesterdayBalance(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("客户权益")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setCustomerEquity(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("当日存取合计")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setTodayTotalAccess(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("质押金")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setQualityDeposit(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("当日盈亏")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setDayProfitAndLoss(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("保证金占用")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setMarginOccupancy(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("当日手续费")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setDayFee(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("可用资金")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setAvailableFunds(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("当日结存")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setTodayBalance(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("风险度")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setRiskDegree(new BigDecimal(tempb.replace(",", "")));
                } else if ((new String(nodes[i].toPlainTextString().getBytes("utf-8")).contains("追加保证金")) && nodes[i + 1].getText().equals("div align=\"right\" style=\"padding-right: 5px;\" class=\"STYLE2 STYLE1\"")) {
                    if (!"".equals(tempb))
                        data.setAdditionalBond(new BigDecimal(tempb.replace(",", "")));
                }
            }
        }
        return data;
    }
}
