package xidaiw.util;


import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;

/**
 * 地址获取 工具类
 * 
 * @author eddie 
 * 
 * @version v1.0 2015-10-20
 */
public class Urls {
	
	/** Host */
	private static String host;
	
	private static String hostwechat;
	/** 轮播图 */
	private static String BannerList;
	
	/** 注册 */
	private static String register;
	
	/** 登录 */
	private static String login;
	/**
	 * 退出登陆
	 */
	private static String logout;
	/**充值**/
	private static String recharge;

	private static String queryImageCode;

	/**去绑卡**/
	private static String doBindingbankCard;
	
	private static String doBindingBankCardAdvance;


	/**
	 * 解析网络xml获取url
	 * 
	 * @param is
	 */
	public static void parse(InputStream is) {
		XmlPullParser xmlParser = Xml.newPullParser();
		try {
			xmlParser.setInput(is, "UTF-8");			
			//获得解析到的事件类别，这里有开始文档，结束文档，开始标签，结束标签，文本等等事件。
            int evtType = xmlParser.getEventType();
            //一直循环，直到文档结束  
			while(evtType != XmlPullParser.END_DOCUMENT){
				switch(evtType){
		    	case XmlPullParser.START_TAG:
		    		//通知信息
		    		if("Item".equals(xmlParser.getName())) {
		    			String name = xmlParser.getAttributeValue(0);
		    			if("host".equals(name)) {
		    				host = xmlParser.getAttributeValue(1);
		    			}
		    			if("hostwechat".equals(name)) {
		    				hostwechat = xmlParser.getAttributeValue(1);
		    			}
		    			if("Banner".equals(name)) {
		    				BannerList = xmlParser.getAttributeValue(1);
		    			}
		    			if("register".equals(name)) {
		    				register = xmlParser.getAttributeValue(1);
		    			}
		    			if("login".equals(name)) {
		    				login = xmlParser.getAttributeValue(1);
		    			}
						if("logout".equals(name)) {
							logout = xmlParser.getAttributeValue(1);
						}
		    			if("queryImageCode".equals(name)) {
		    				queryImageCode = xmlParser.getAttributeValue(1);
		    			}
		    			if("doBindingbankCard".equals(name)) {
		    				doBindingbankCard = xmlParser.getAttributeValue(1);
		    			}
		    			if("doBindingBankCardAdvance".equals(name)) {
		    				doBindingBankCardAdvance = xmlParser.getAttributeValue(1);
		    			}
		    		}
		    		break;
		        		
				}
			    evtType=xmlParser.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static String getHost() {
		return host;
	}


	public static void setHost(String host) {
		Urls.host = host;
	}

	public static String getBannerList() {
		return host+BannerList;
	}

	public static void setBannerList(String bannerList) {
		BannerList = bannerList;
	}

	public static String getRegister() {
		return host+ register;
	}

	public static void setRegister(String register) {
		Urls.register = register;
	}

	public static String getLogin() {
		return host+ login;
	}

	public static void setLogin(String login) {
		Urls.login = login;
	}

	public static String getLogout() {
		return host+ logout;
	}

	public static void setLogout(String logout) {
		Urls.logout = logout;
	}

	public static String getRecharge() {
		return host+ recharge;
	}

	public static void setRecharge(String recharge) {
		Urls.recharge = recharge;
	}

	public static String getQueryImageCode() {
		return host+queryImageCode;
	}

	public static void setQueryImageCode(String queryImageCode) {
		Urls.queryImageCode = queryImageCode;
	}

	public static String getDoBindingbankCard() {
		return host+doBindingbankCard;
	}

	public static void setDoBindingbankCard(String doBindingbankCard) {
		Urls.doBindingbankCard = doBindingbankCard;
	}

	public static String getDoBindingBankCardAdvance() {
		return host+doBindingBankCardAdvance;
	}

	public static void setDoBindingBankCardAdvance(String doBindingBankCardAdvance) {
		Urls.doBindingBankCardAdvance = doBindingBankCardAdvance;
	}
}
