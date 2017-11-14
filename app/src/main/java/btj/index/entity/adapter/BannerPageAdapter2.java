package btj.index.entity.adapter;

//首页轮播图和推荐标的适配器

import btj.index.entity.DataBean;

/**
 o-JSON
 n-code : 1
 o-data
 v-message : "查询成功"
 b-success : true
 */
public class BannerPageAdapter2 {

	/**
	 * code : 1
	 * data : {"bannerList":[{"channelId":0,"createTime":"2017-10-30 14:31:11","enable":true,"htmlTitle":"推荐有礼榜","htmlURL":"http://activity.xidaiw.com/event/recommendWap","id":68,"imageURI":"http://101.37.174.8/ftp_user/banner/20171030.png","name":"推荐有礼榜","osType":"OS_IOS_ANDROID","sortParameter":236,"updateTime":"2017-10-30 14:31:59"},{"channelId":0,"createTime":"2017-10-17 11:24:57","enable":true,"htmlTitle":"注册四重礼","htmlURL":"http://101.37.174.8/ftp_user/apphtml/xrzx/xrzx.html","id":64,"imageURI":"http://101.37.174.8/ftp_user/banner/20171017.png","name":"注册四重礼","osType":"OS_IOS_ANDROID","sortParameter":235,"updateTime":"2017-10-17 11:25:54"},{"channelId":0,"createTime":"2017-10-17 11:33:25","enable":true,"htmlTitle":"银行存管","id":66,"imageURI":"http://101.37.174.8/ftp_user/banner/201710171.png","name":"银行存管","osType":"OS_IOS_ANDROID","sortParameter":234,"updateTime":"2017-10-17 11:34:27"},{"channelId":0,"createTime":"2016-03-18 18:49:03","enable":true,"htmlTitle":"邀请有礼","htmlURL":"http://101.37.174.8/ftp_user/apphtml/yqyl/inviteFriends.html","id":16,"imageURI":"http://101.37.174.8/ftp_user/banner/bannerWap.png","name":"邀请有礼","osType":"OS_IOS_ANDROID","sortParameter":8,"updateTime":"2017-02-28 02:25:54"},{"channelId":0,"createTime":"2015-11-05 16:53:50","enable":true,"htmlTitle":"五重保障护航","htmlURL":"#","id":1,"imageURI":"http://101.37.174.8/ftp_user/banner/aqbz31banner.png","name":"安全保障","osType":"OS_IOS_ANDROID","sortParameter":7,"updateTime":"2017-05-27 15:04:09"},{"channelId":0,"createTime":"2017-08-25 11:24:35","enable":true,"htmlTitle":"喜袋榜","htmlURL":"http://activity.xidaiw.com/event/xidaiw/wap/index/1","id":56,"imageURI":"http://101.37.174.8/ftp_user/banner/xidaibang.png","name":"喜袋网","osType":"OS_IOS_ANDROID"}],"product":{"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":119,"idStr":"BBBBGGfb4","interest":10.8,"maturityDuration":"60天","maxAmount":500,"maxInterest":10.8,"minAmount":1,"minInterest":10.8,"normalInterest":7.800000000000001,"passTime":"2017-08-01 09:40:07","productChannelId":2,"productInterestType":"固定收益","productName":"奥迪Q7 抵押借款","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":true,"remainingAmount":0,"saleAmount":500,"saleEndTime":"2017-07-29 00:00:00","saleStartTime":"2017-07-26 16:01:45","startBuyTime":"0时0分","startInterestDate":"2017-08-01","totalAmount":50000,"totalBuyNumber":3,"totalCopies":500}}
	 * message : 查询成功
	 * success : true
	 */

	private int code;
	private DataBean data;
	private String message;
	private boolean success;

	public static BannerPageAdapter2 objectFromData(String str) {

		return new com.google.gson.Gson().fromJson(str, BannerPageAdapter2.class);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


}
