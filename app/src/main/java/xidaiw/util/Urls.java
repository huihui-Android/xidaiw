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
	
	/** 统计数据 */
	private static String StatisticsData;
	
	/** 公告 */
	private static String Notice;
	
	/** 理财产品 */
	private static String AppProduct;
	
	/** 标详情 */
	private static String BidDetail;
	
	/** 本期投资人数 */
	private static String BidInvestorCount;
	
	/** 投资 */
	private static String investBid;
	
	/** 注册 */
	private static String register;
	
	/** 登录 */
	private static String login;
	
	/**充值**/
	private static String recharge;
	
	private static String queryAllDebt;
	
	private static String queryImageCode;
	//实名认证
	private static String certifyRealName;
	
	private static String queryUserInfo;
	/**去绑卡**/
	private static String doBindingbankCard;
	
	private static String doBindingBankCardAdvance;
	
	private static String queryRecharge;
	
	private static String rechargeAdvance;
	
	private static String BidDetaill;
	
	private static String queryProject;
	
	private static String sendMessage;
	
	private static String queryRisk;
	
	private static String queryRepaymentPlan;
	
	private static String queryTransferDetail;

	private static String AddTransferPro;
	
	private static String queryTransferRecord;
	
	private static String queryBidRecord;
	
	private static String queryTransferRecordList;
	
	private static String queryCapitalFlow;
	
	private static String queryCapitalFlowList;
	
	private static String queryMyPoints;
	
	private static String doPointsChange;
	
	private static String queryPointsRecord;
	
	private static String doModifyPhone;
	
	private static String unbindingbankcard;
	
	private static String doTransactionPass;
	
	private static String doforgetPayPassword;
	
	private static String queryNoticeTitle;
	
	private static String querytransRecord;
	
	private static String MembersClub;
	
	private static String queryAppVersion;
	
	private static String version;
	
	private static String doAccountUpdate;
	/** 公告提示*/
	private static String queryNotice;
	
	/** 公告提示详情*/
	private static String queryNoticeDetail;
	
	/** 常见问题*/
	private static String moreCommonProblem;
	
	/** 如何注册*/
	private static String moreregister;
	
	/** 如何充值*/
	private static String morerecharge;
	
	/** 如何提现*/
	private static String moreWithdrawals;
	
	/** 如何投资*/
	private static String moreInvest;
	
	/** 债权转让*/
	private static String moreTransfer;
	
	/** 网站资费*/
	private static String moreWebsiteTariff;
	
	/** 法律声明*/
	private static String moreLegalDeclaration;
	
	/** 关于我们*/
	private static String moreAboutUs;
	
	/** 安全保障*/
	private static String moreSecurity;
	
	/** 联系我们*/
	private static String moreContactUs;
	
	/** 合作伙伴*/
	private static String queryPartner;
	
	/** 个人中心*/
	private static String queryPersonalCenter;
	
	private static String transfersBid;
	
	private static String queryInvestDetail;
	
	private static String queryMydebt;
	
	private static String Trans_HostingCollectTrade;

	private static String queryMydebtList;
	
	/** 获取用户头像*/
	private static String homePhotoUpload;
	
	/** 提现显示页面*/
	private static String queryWithdrawals;
	
	/** 提现提交*/
	private static String doWithdrawals;
	
	private static String ForgetPassword;
	
	private static String modifyLoginPwd;
	
	private static String doModifyPass;
	
	private static String queryMyLoan;
	
	private static String queryMyLoanList;
	
	private static String queryOverdueList;
	
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
		    			if("StatisticsData".equals(name)) {
		    				StatisticsData = xmlParser.getAttributeValue(1);
		    			}
		    			if("Notice".equals(name)) {
		    				Notice = xmlParser.getAttributeValue(1);
		    			}
		    			if("AppProduct".equals(name)) {
		    				AppProduct = xmlParser.getAttributeValue(1);
		    			}
		    			if("BidDetail".equals(name)) {
		    				BidDetail = xmlParser.getAttributeValue(1);
		    			}
		    			if("BidInvestorCount".equals(name)) {
		    				BidInvestorCount = xmlParser.getAttributeValue(1);
		    			}
		    			if("investBid".equals(name)) {
		    				investBid = xmlParser.getAttributeValue(1);
		    			}
		    			if("register".equals(name)) {
		    				register = xmlParser.getAttributeValue(1);
		    			}
		    			if("login".equals(name)) {
		    				login = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryAllDebt".equals(name)) {
		    				queryAllDebt = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryImageCode".equals(name)) {
		    				queryImageCode = xmlParser.getAttributeValue(1);
		    			}
		    			if("certifyRealName".equals(name)) {
		    				certifyRealName = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryUserInfo".equals(name)) {
		    				queryUserInfo = xmlParser.getAttributeValue(1);
		    			}
		    			if("doBindingbankCard".equals(name)) {
		    				doBindingbankCard = xmlParser.getAttributeValue(1);
		    			}
		    			if("doBindingBankCardAdvance".equals(name)) {
		    				doBindingBankCardAdvance = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryRecharge".equals(name)) {
		    				queryRecharge = xmlParser.getAttributeValue(1);
		    			}
		    			if("rechargeAdvance".equals(name)) {
		    				rechargeAdvance = xmlParser.getAttributeValue(1);
		    			}
		    			if("BidDetaill".equals(name)) {
		    				BidDetaill = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryProject".equals(name)) {
		    				queryProject = xmlParser.getAttributeValue(1);
		    			}
		    			if("sendMessage".equals(name)) {
		    				sendMessage = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryRisk".equals(name)) {
		    				queryRisk = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryRepaymentPlan".equals(name)) {
		    				queryRepaymentPlan = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryTransferDetail".equals(name)) {
		    				queryTransferDetail = xmlParser.getAttributeValue(1);
		    			}

		    			if("queryNotice".equals(name)) {
		    				queryNotice = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryNoticeDetail".equals(name)) {
		    				queryNoticeDetail = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreCommonProblem".equals(name)) {
		    				moreCommonProblem = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreregister".equals(name)) {
		    				moreregister = xmlParser.getAttributeValue(1);
		    			}
		    			if("morerecharge".equals(name)) {
		    				morerecharge = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreWithdrawals".equals(name)) {
		    				moreWithdrawals = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreInvest".equals(name)) {
		    				moreInvest = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreTransfer".equals(name)) {
		    				moreTransfer = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreWebsiteTariff".equals(name)) {
		    				moreWebsiteTariff = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreLegalDeclaration".equals(name)) {
		    				moreLegalDeclaration = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreAboutUs".equals(name)) {
		    				moreAboutUs = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreSecurity".equals(name)) {
		    				moreSecurity = xmlParser.getAttributeValue(1);
		    			}
		    			if("moreContactUs".equals(name)) {
		    				moreContactUs = xmlParser.getAttributeValue(1);
		    			}

		    			if("transfersBid".equals(name)) {
		    				transfersBid = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryInvestDetail".equals(name)) {
		    				queryInvestDetail = xmlParser.getAttributeValue(1);
		    			}
		    			if("recharge".equals(name)) {
		    				recharge = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryMydebt".equals(name)) {
		    				queryMydebt = xmlParser.getAttributeValue(1);
		    			}
		    			if("Trans_HostingCollectTrade".equals(name)) {
		    				Trans_HostingCollectTrade = xmlParser.getAttributeValue(1);
		    			}

		    			if("queryMydebtList".equals(name)) {
		    				queryMydebtList = xmlParser.getAttributeValue(1);
		    			}
		    			
		    			if("AddTransferPro".equals(name)) {
		    				AddTransferPro = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryTransferRecord".equals(name)) {
		    				queryTransferRecord = xmlParser.getAttributeValue(1);
		    			}

		    			if("queryPartner".equals(name)) {
		    				queryPartner = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryPersonalCenter".equals(name)) {
		    				queryPersonalCenter = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryBidRecord".equals(name)) {
		    				queryBidRecord = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryTransferRecordList".equals(name)) {
		    				queryTransferRecordList = xmlParser.getAttributeValue(1);
		    			}

		    			if("homePhotoUpload".equals(name)) {
		    				homePhotoUpload = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryCapitalFlow".equals(name)) {
		    				queryCapitalFlow = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryCapitalFlowList".equals(name)) {
		    				queryCapitalFlowList = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryWithdrawals".equals(name)) {
		    				queryWithdrawals = xmlParser.getAttributeValue(1);
		    			}

		    			if("queryMyPoints".equals(name)) {
		    				queryMyPoints = xmlParser.getAttributeValue(1);
		    			}
		    			if("doPointsChange".equals(name)) {
		    				doPointsChange = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryPointsRecord".equals(name)) {
		    				queryPointsRecord = xmlParser.getAttributeValue(1);
		    			}

		    			if("ForgetPassword".equals(name)) {
		    				ForgetPassword = xmlParser.getAttributeValue(1);
		    			}
		    			if("modifyLoginPwd".equals(name)) {
		    				modifyLoginPwd = xmlParser.getAttributeValue(1);
		    			}

		    			if("doModifyPhone".equals(name)) {
		    				doModifyPhone = xmlParser.getAttributeValue(1);
		    			}
		    			if("unbindingbankcard".equals(name)) {
		    				unbindingbankcard = xmlParser.getAttributeValue(1);
		    			}

		    			if("doWithdrawals".equals(name)) {
		    				doWithdrawals = xmlParser.getAttributeValue(1);
		    			}

		    			if("doTransactionPass".equals(name)) {
		    				doTransactionPass = xmlParser.getAttributeValue(1);
		    			}
	
		    			if("doModifyPass".equals(name)) {
		    				doModifyPass = xmlParser.getAttributeValue(1);
		    			}
		    			
		    			if("doforgetPayPassword".equals(name)) {
		    				doforgetPayPassword = xmlParser.getAttributeValue(1);
		    			}
		    			
		    			if("queryMyLoan".equals(name)) {
		    				queryMyLoan = xmlParser.getAttributeValue(1);
		    			}
		    			
		    			if("queryMyLoanList".equals(name)) {
		    				queryMyLoanList = xmlParser.getAttributeValue(1);
		    			}
		    			
		    			if("queryOverdueList".equals(name)) {
		    				queryOverdueList = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryNoticeTitle".equals(name)) {
		    				queryNoticeTitle = xmlParser.getAttributeValue(1);
		    			}
		    			if("querytransRecord".equals(name)) {
		    				querytransRecord = xmlParser.getAttributeValue(1);
		    			}
		    			if("MembersClub".equals(name)) {
		    				MembersClub = xmlParser.getAttributeValue(1);
		    			}
		    			if("queryAppVersion".equals(name)) {
		    				queryAppVersion = xmlParser.getAttributeValue(1);
		    			}
		    			if("version".equals(name)) {
		    				version = xmlParser.getAttributeValue(1);
		    			}
		    			if("doAccountUpdate".equals(name)) {
		    				doAccountUpdate = xmlParser.getAttributeValue(1);
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



	public static String getStatisticsData() {
		return host+StatisticsData;
	}



	public static void setStatisticsData(String statisticsData) {
		StatisticsData = statisticsData;
	}



	public static String getNotice() {
		return host+Notice;
	}



	public static void setNotice(String notice) {
		Notice = notice;
	}



	public static String getAppProduct() {
		return host+AppProduct;
	}



	public static void setAppProduct(String appProduct) {
		AppProduct = appProduct;
	}



	public static String getBidDetail() {
		return host+ BidDetail;
	}



	public static void setBidDetail(String bidDetail) {
		BidDetail = bidDetail;
	}



	public static String getBidInvestorCount() {
		return host+ BidInvestorCount;
	}



	public static void setBidInvestorCount(String bidInvestorCount) {
		BidInvestorCount = bidInvestorCount;
	}



	public static String getInvestBid() {
		return host+ investBid;
	}



	public static void setInvestBid(String investBid) {
		Urls.investBid = investBid;
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



	public static String getRecharge() {
		return host+ recharge;
	}



	public static void setRecharge(String recharge) {
		Urls.recharge = recharge;
	}



	public static String getQueryAllDebt() {
		return host+queryAllDebt;
	}



	public static void setQueryAllDebt(String queryAllDebt) {
		Urls.queryAllDebt = queryAllDebt;
	}



	public static String getQueryImageCode() {
		return host+queryImageCode;
	}



	public static void setQueryImageCode(String queryImageCode) {
		Urls.queryImageCode = queryImageCode;
	}



	public static String getCertifyRealName() {
		return host+certifyRealName;
	}



	public static void setCertifyRealName(String certifyRealName) {
		Urls.certifyRealName = certifyRealName;
	}



	public static String getQueryUserInfo() {
		return host+queryUserInfo;
	}



	public static void setQueryUserInfo(String queryUserInfo) {
		Urls.queryUserInfo = queryUserInfo;
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



	public static String getQueryRecharge() {
		return host+queryRecharge;
	}



	public static void setQueryRecharge(String queryRecharge) {
		Urls.queryRecharge = queryRecharge;
	}



	public static String getRechargeAdvance() {
		return host+rechargeAdvance;
	}



	public static void setRechargeAdvance(String rechargeAdvance) {
		Urls.rechargeAdvance = rechargeAdvance;
	}



	public static String getBidDetaill() {
		return host+BidDetaill;
	}



	public static void setBidDetaill(String bidDetaill) {
		BidDetaill = bidDetaill;
	}



	public static String getQueryProject() {
		return host+queryProject;
	}



	public static void setQueryProject(String queryProject) {
		Urls.queryProject = queryProject;
	}



	public static String getSendMessage() {
		return host+sendMessage;
	}



	public static void setSendMessage(String sendMessage) {
		Urls.sendMessage = sendMessage;
	}



	public static String getQueryRisk() {
		return host+queryRisk;
	}



	public static void setQueryRisk(String queryRisk) {
		Urls.queryRisk = queryRisk;
	}



	public static String getQueryRepaymentPlan() {
		return host+queryRepaymentPlan;
	}



	public static void setQueryRepaymentPlan(String queryRepaymentPlan) {
		Urls.queryRepaymentPlan = queryRepaymentPlan;
	}



	public static String getQueryTransferDetail() {
		return host+queryTransferDetail;
	}



	public static void setQueryTransferDetail(String queryTransferDetail) {
		Urls.queryTransferDetail = queryTransferDetail;
	}




	public static String getQueryNotice() {
		return host+queryNotice;
	}



	public static void setQueryNotice(String queryNotice) {
		Urls.queryNotice = queryNotice;
	}



	public static String getQueryNoticeDetail() {
		return host+queryNoticeDetail;
	}



	public static void setQueryNoticeDetail(String queryNoticeDetail) {
		Urls.queryNoticeDetail = queryNoticeDetail;
	}

	public static String getMoreCommonProblem() {
		return host+moreCommonProblem;
	}



	public static void setMoreCommonProblem(String moreCommonProblem) {
		Urls.moreCommonProblem = moreCommonProblem;
	}


	public static String getMoreregister() {
		return host+moreregister;
	}



	public static void setMoreregister(String moreregister) {
		Urls.moreregister = moreregister;
	}



	public static String getMorerecharge() {
		return host+morerecharge;
	}



	public static void setMorerecharge(String morerecharge) {
		Urls.morerecharge = morerecharge;
	}



	public static String getMoreWithdrawals() {
		return host+moreWithdrawals;
	}



	public static void setMoreWithdrawals(String moreWithdrawals) {
		Urls.moreWithdrawals = moreWithdrawals;
	}



	public static String getMoreInvest() {
		return host+moreInvest;
	}



	public static void setMoreInvest(String moreInvest) {
		Urls.moreInvest = moreInvest;
	}



	public static String getMoreTransfer() {
		return host+moreTransfer;
	}



	public static void setMoreTransfer(String moreTransfer) {
		Urls.moreTransfer = moreTransfer;
	}



	public static String getMoreWebsiteTariff() {
		return host+moreWebsiteTariff;
	}



	public static void setMoreWebsiteTariff(String moreWebsiteTariff) {
		Urls.moreWebsiteTariff = moreWebsiteTariff;
	}



	public static String getMoreLegalDeclaration() {
		return host+moreLegalDeclaration;
	}



	public static void setMoreLegalDeclaration(String moreLegalDeclaration) {
		Urls.moreLegalDeclaration = moreLegalDeclaration;
	}



	public static String getMoreAboutUs() {
		return host+moreAboutUs;
	}



	public static void setMoreAboutUs(String moreAboutUs) {
		Urls.moreAboutUs = moreAboutUs;
	}



	public static String getMoreSecurity() {
		return host+moreSecurity;
	}



	public static void setMoreSecurity(String moreSecurity) {
		Urls.moreSecurity = moreSecurity;
	}



	public static String getMoreContactUs() {
		return host+moreContactUs;
	}



	public static void setMoreContactUs(String moreContactUs) {
		Urls.moreContactUs = moreContactUs;
	}



	public static String getTransfersBid() {
		return host+transfersBid;
	}



	public static void setTransfersBid(String transfersBid) {
		Urls.transfersBid = transfersBid;
	}



	public static String getQueryInvestDetail() {
		return host+queryInvestDetail;
	}



	public static void setQueryInvestDetail(String queryInvestDetail) {
		Urls.queryInvestDetail = queryInvestDetail;
	}



	public static String getQueryMydebt() {
		return host+queryMydebt;
	}



	public static void setQueryMydebt(String queryMydebt) {
		Urls.queryMydebt = queryMydebt;
	}



	public static String getTrans_HostingCollectTrade() {
		return host+Trans_HostingCollectTrade;
	}



	public static void setTrans_HostingCollectTrade(String trans_HostingCollectTrade) {
		Trans_HostingCollectTrade = trans_HostingCollectTrade;
	}




	public static String getQueryMydebtList() {
		return host+queryMydebtList;
	}



	public static void setQueryMydebtList(String queryMydebtList) {
		Urls.queryMydebtList = queryMydebtList;
	}



	public static String getAddTransferPro() {
		return host+AddTransferPro;
	}



	public static void setAddTransferPro(String addTransferPro) {
		AddTransferPro = addTransferPro;
	}



	public static String getQueryTransferRecord() {
		return host+queryTransferRecord;
	}



	public static void setQueryTransferRecord(String queryTransferRecord) {
		Urls.queryTransferRecord = queryTransferRecord;
	}




	public static String getQueryPartner() {
		return host+queryPartner;
	}



	public static void setQueryPartner(String queryPartner) {
		Urls.queryPartner = queryPartner;
	}

	public static String getQueryPersonalCenter() {
		return host+queryPersonalCenter;
	}



	public static void setQueryPersonalCenter(String queryPersonalCenter) {
		Urls.queryPersonalCenter = queryPersonalCenter;
	}



	public static String getQueryBidRecord() {
		return host+queryBidRecord;
	}



	public static void setQueryBidRecord(String queryBidRecord) {
		Urls.queryBidRecord = queryBidRecord;
	}
	
	public static String getHomePhotoUpload() {
		return host+homePhotoUpload;
	}



	public static void setHomePhotoUpload(String homePhotoUpload) {
		Urls.homePhotoUpload = homePhotoUpload;
	}



	public static String getQueryTransferRecordList() {
		return host+queryTransferRecordList;
	}



	public static void setQueryTransferRecordList(String queryTransferRecordList) {
		Urls.queryTransferRecordList = queryTransferRecordList;
	}



	public static String getQueryCapitalFlow() {
		return host+queryCapitalFlow;
	}



	public static void setQueryCapitalFlow(String queryCapitalFlow) {
		Urls.queryCapitalFlow = queryCapitalFlow;
	}



	public static String getQueryCapitalFlowList() {
		return host+queryCapitalFlowList;
	}



	public static void setQueryCapitalFlowList(String queryCapitalFlowList) {
		Urls.queryCapitalFlowList = queryCapitalFlowList;
	}
	
	public static String getForgetPassword() {
		return host+ForgetPassword;
	}

	public static String getQueryWithdrawals() {
		return host+queryWithdrawals;
	}

	public static void setQueryWithdrawals(String queryWithdrawals) {
		Urls.queryWithdrawals = queryWithdrawals;
	}

	public static void setForgetPassword(String ForgetPassword) {
		Urls.ForgetPassword = ForgetPassword;
	}
	
	public static String getModifyLoginPwd() {
		return host+modifyLoginPwd;
	}

	public static void setModifyLoginPwd(String modifyLoginPwd) {
		Urls.modifyLoginPwd = modifyLoginPwd;
	}



	public static String getQueryMyPoints() {
		return host+queryMyPoints;
	}



	public static void setQueryMyPoints(String queryMyPoints) {
		Urls.queryMyPoints = queryMyPoints;
	}



	public static String getDoPointsChange() {
		return host+doPointsChange;
	}



	public static void setDoPointsChange(String doPointsChange) {
		Urls.doPointsChange = doPointsChange;
	}



	public static String getQueryPointsRecord() {
		return host+queryPointsRecord;
	}



	public static void setQueryPointsRecord(String queryPointsRecord) {
		Urls.queryPointsRecord = queryPointsRecord;
	}




	public static String getDoModifyPhone() {
		return host+doModifyPhone;
	}



	public static void setDoModifyPhone(String doModifyPhone) {
		Urls.doModifyPhone = doModifyPhone;
	}



	public static String getUnbindingbankcard() {
		return host+unbindingbankcard;
	}



	public static void setUnbindingbankcard(String unbindingbankcard) {
		Urls.unbindingbankcard = unbindingbankcard;
	}


	public static String getDoWithdrawals() {
		return host+doWithdrawals;
	}

	public static void setDoWithdrawals(String doWithdrawals) {
		Urls.doWithdrawals = doWithdrawals;
	}



	public static String getDoTransactionPass() {
		return host+doTransactionPass;
	}



	public static void setDoTransactionPass(String doTransactionPass) {
		Urls.doTransactionPass = doTransactionPass;
	}
	
	public static String getDoModifyPass() {
		return host+doModifyPass;
	}

	public static void setDoModifyPass(String doModifyPass) {
		Urls.doModifyPass = doModifyPass;
	}



	public static String getDoforgetPayPassword() {
		return host+doforgetPayPassword;
	}



	public static void setDoforgetPayPassword(String doforgetPayPassword) {
		Urls.doforgetPayPassword = doforgetPayPassword;
	}
	
	public static String getQueryMyLoan() {
		return host+queryMyLoan;
	}

	public static void setQueryMyLoan(String queryMyLoan) {
		Urls.queryMyLoan = queryMyLoan;
	}
	
	public static String getQueryMyLoanList() {
		return host+queryMyLoanList;
	}

	public static void setQueryMyLoanList(String queryMyLoanList) {
		Urls.queryMyLoanList = queryMyLoanList;
	}
	
	public static String getQueryOverdueList() {
		return host+queryOverdueList;
	}

	public static void setQueryOverdueList(String queryOverdueList) {
		Urls.queryOverdueList = queryOverdueList;
	}



	public static String getQueryNoticeTitle() {
		return host+queryNoticeTitle;
	}



	public static void setQueryNoticeTitle(String queryNoticeTitle) {
		Urls.queryNoticeTitle = queryNoticeTitle;
	}



	public static String getQuerytransRecord() {
		return host+querytransRecord;
	}



	public static void setQuerytransRecord(String querytransRecord) {
		Urls.querytransRecord = querytransRecord;
	}



	public static String getMembersClub() {
		return hostwechat+MembersClub;
	}



	public static void setMembersClub(String membersClub) {
		MembersClub = membersClub;
	}



	public static String getHostwechat() {
		return hostwechat;
	}



	public static void setHostwechat(String hostwechat) {
		Urls.hostwechat = hostwechat;
	}



	public static String getQueryAppVersion() {
		return host+queryAppVersion;
	}



	public static void setQueryAppVersion(String queryAppVersion) {
		Urls.queryAppVersion = queryAppVersion;
	}



	public static String getVersion() {
		return version;
	}



	public static void setVersion(String version) {
		Urls.version = version;
	}



	public static String getDoAccountUpdate() {
		return host+doAccountUpdate;
	}



	public static void setDoAccountUpdate(String doAccountUpdate) {
		Urls.doAccountUpdate = doAccountUpdate;
	}
	
}
