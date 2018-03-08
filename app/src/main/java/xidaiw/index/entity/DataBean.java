package xidaiw.index.entity;

import java.util.List;

/**
 * Created by admin on 2017/11/7.
 */

public class DataBean {
    /**
     * bannerList : [{"channelId":0,"createTime":"2017-10-30 14:31:11","enable":true,"htmlTitle":"推荐有礼榜","htmlURL":"http://activity.xidaiw.com/event/recommendWap","id":68,"imageURI":"http://101.37.174.8/ftp_user/banner/20171030.png","name":"推荐有礼榜","osType":"OS_IOS_ANDROID","sortParameter":236,"updateTime":"2017-10-30 14:31:59"},{"channelId":0,"createTime":"2017-10-17 11:24:57","enable":true,"htmlTitle":"注册四重礼","htmlURL":"http://101.37.174.8/ftp_user/apphtml/xrzx/xrzx.html","id":64,"imageURI":"http://101.37.174.8/ftp_user/banner/20171017.png","name":"注册四重礼","osType":"OS_IOS_ANDROID","sortParameter":235,"updateTime":"2017-10-17 11:25:54"},{"channelId":0,"createTime":"2017-10-17 11:33:25","enable":true,"htmlTitle":"银行存管","id":66,"imageURI":"http://101.37.174.8/ftp_user/banner/201710171.png","name":"银行存管","osType":"OS_IOS_ANDROID","sortParameter":234,"updateTime":"2017-10-17 11:34:27"},{"channelId":0,"createTime":"2016-03-18 18:49:03","enable":true,"htmlTitle":"邀请有礼","htmlURL":"http://101.37.174.8/ftp_user/apphtml/yqyl/inviteFriends.html","id":16,"imageURI":"http://101.37.174.8/ftp_user/banner/bannerWap.png","name":"邀请有礼","osType":"OS_IOS_ANDROID","sortParameter":8,"updateTime":"2017-02-28 02:25:54"},{"channelId":0,"createTime":"2015-11-05 16:53:50","enable":true,"htmlTitle":"五重保障护航","htmlURL":"#","id":1,"imageURI":"http://101.37.174.8/ftp_user/banner/aqbz31banner.png","name":"安全保障","osType":"OS_IOS_ANDROID","sortParameter":7,"updateTime":"2017-05-27 15:04:09"},{"channelId":0,"createTime":"2017-08-25 11:24:35","enable":true,"htmlTitle":"喜袋榜","htmlURL":"http://activity.xidaiw.com/event/xidaiw/wap/index/1","id":56,"imageURI":"http://101.37.174.8/ftp_user/banner/xidaibang.png","name":"喜袋网","osType":"OS_IOS_ANDROID"}]
     * product : {"activityDescription":"","appshouDesciption":"app","awardInterest":3,"baseAmount":100,"canJoin":true,"canJoinCode":0,"cornerType":"CLOSED","descriptionTitle":"车辆抵押","endBuyTime":"24时0分","finishRatio":100,"id":119,"idStr":"BBBBGGfb4","interest":10.8,"maturityDuration":"60天","maxAmount":500,"maxInterest":10.8,"minAmount":1,"minInterest":10.8,"normalInterest":7.800000000000001,"passTime":"2017-08-01 09:40:07","productChannelId":2,"productInterestType":"固定收益","productName":"奥迪Q7 抵押借款","productStatus":"ENDED","productStatusValue":"已结束","productTypeName":"常规固定期限产品","productTypeValue":"FIXED_TERM_PRODUCT","recommend":true,"remainingAmount":0,"saleAmount":500,"saleEndTime":"2017-07-29 00:00:00","saleStartTime":"2017-07-26 16:01:45","startBuyTime":"0时0分","startInterestDate":"2017-08-01","totalAmount":50000,"totalBuyNumber":3,"totalCopies":500}
     */

    private ProductBean product;
    private List<BannerListBean> bannerList;

    public static DataBean objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, DataBean.class);
    }

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public List<BannerListBean> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<BannerListBean> bannerList) {
        this.bannerList = bannerList;
    }

//    public static class ProductBean {
//        /**
//         * activityDescription :
//         * appshouDesciption : app
//         * awardInterest : 3.0
//         * baseAmount : 100.0
//         * canJoin : true
//         * canJoinCode : 0
//         * cornerType : CLOSED
//         * descriptionTitle : 车辆抵押
//         * endBuyTime : 24时0分
//         * finishRatio : 100.0
//         * id : 119
//         * idStr : BBBBGGfb4
//         * interest : 10.8
//         * maturityDuration : 60天
//         * maxAmount : 500
//         * maxInterest : 10.8
//         * minAmount : 1
//         * minInterest : 10.8
//         * normalInterest : 7.800000000000001
//         * passTime : 2017-08-01 09:40:07
//         * productChannelId : 2
//         * productInterestType : 固定收益
//         * productName : 奥迪Q7 抵押借款
//         * productStatus : ENDED
//         * productStatusValue : 已结束
//         * productTypeName : 常规固定期限产品
//         * productTypeValue : FIXED_TERM_PRODUCT
//         * recommend : true
//         * remainingAmount : 0
//         * saleAmount : 500
//         * saleEndTime : 2017-07-29 00:00:00
//         * saleStartTime : 2017-07-26 16:01:45
//         * startBuyTime : 0时0分
//         * startInterestDate : 2017-08-01
//         * totalAmount : 50000
//         * totalBuyNumber : 3
//         * totalCopies : 500
//         */
//
//        private String activityDescription;
//        private String appshouDesciption;
//        private double awardInterest;
//        private double baseAmount;
//        private boolean canJoin;
//        private int canJoinCode;
//        private String cornerType;
//        private String descriptionTitle;
//        private String endBuyTime;
//        private double finishRatio;
//        private int id;
//        private String idStr;
//        private double interest;
//        private String maturityDuration;
//        private int maxAmount;
//        private double maxInterest;
//        private int minAmount;
//        private double minInterest;
//        private double normalInterest;
//        private String passTime;
//        private int productChannelId;
//        private String productInterestType;
//        private String productName;
//        private String productStatus;
//        private String productStatusValue;
//        private String productTypeName;
//        private String productTypeValue;
//        private boolean recommend;
//        private int remainingAmount;
//        private int saleAmount;
//        private String saleEndTime;
//        private String saleStartTime;
//        private String startBuyTime;
//        private String startInterestDate;
//        private int totalAmount;
//        private int totalBuyNumber;
//        private int totalCopies;
//
//        public static ProductBean objectFromData(String str) {
//
//            return new com.google.gson.Gson().fromJson(str, ProductBean.class);
//        }
//
//        public String getActivityDescription() {
//            return activityDescription;
//        }
//
//        public void setActivityDescription(String activityDescription) {
//            this.activityDescription = activityDescription;
//        }
//
//        public String getAppshouDesciption() {
//            return appshouDesciption;
//        }
//
//        public void setAppshouDesciption(String appshouDesciption) {
//            this.appshouDesciption = appshouDesciption;
//        }
//
//        public double getAwardInterest() {
//            return awardInterest;
//        }
//
//        public void setAwardInterest(double awardInterest) {
//            this.awardInterest = awardInterest;
//        }
//
//        public double getBaseAmount() {
//            return baseAmount;
//        }
//
//        public void setBaseAmount(double baseAmount) {
//            this.baseAmount = baseAmount;
//        }
//
//        public boolean isCanJoin() {
//            return canJoin;
//        }
//
//        public void setCanJoin(boolean canJoin) {
//            this.canJoin = canJoin;
//        }
//
//        public int getCanJoinCode() {
//            return canJoinCode;
//        }
//
//        public void setCanJoinCode(int canJoinCode) {
//            this.canJoinCode = canJoinCode;
//        }
//
//        public String getCornerType() {
//            return cornerType;
//        }
//
//        public void setCornerType(String cornerType) {
//            this.cornerType = cornerType;
//        }
//
//        public String getDescriptionTitle() {
//            return descriptionTitle;
//        }
//
//        public void setDescriptionTitle(String descriptionTitle) {
//            this.descriptionTitle = descriptionTitle;
//        }
//
//        public String getEndBuyTime() {
//            return endBuyTime;
//        }
//
//        public void setEndBuyTime(String endBuyTime) {
//            this.endBuyTime = endBuyTime;
//        }
//
//        public double getFinishRatio() {
//            return finishRatio;
//        }
//
//        public void setFinishRatio(double finishRatio) {
//            this.finishRatio = finishRatio;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getIdStr() {
//            return idStr;
//        }
//
//        public void setIdStr(String idStr) {
//            this.idStr = idStr;
//        }
//
//        public double getInterest() {
//            return interest;
//        }
//
//        public void setInterest(double interest) {
//            this.interest = interest;
//        }
//
//        public String getMaturityDuration() {
//            return maturityDuration;
//        }
//
//        public void setMaturityDuration(String maturityDuration) {
//            this.maturityDuration = maturityDuration;
//        }
//
//        public int getMaxAmount() {
//            return maxAmount;
//        }
//
//        public void setMaxAmount(int maxAmount) {
//            this.maxAmount = maxAmount;
//        }
//
//        public double getMaxInterest() {
//            return maxInterest;
//        }
//
//        public void setMaxInterest(double maxInterest) {
//            this.maxInterest = maxInterest;
//        }
//
//        public int getMinAmount() {
//            return minAmount;
//        }
//
//        public void setMinAmount(int minAmount) {
//            this.minAmount = minAmount;
//        }
//
//        public double getMinInterest() {
//            return minInterest;
//        }
//
//        public void setMinInterest(double minInterest) {
//            this.minInterest = minInterest;
//        }
//
//        public double getNormalInterest() {
//            return normalInterest;
//        }
//
//        public void setNormalInterest(double normalInterest) {
//            this.normalInterest = normalInterest;
//        }
//
//        public String getPassTime() {
//            return passTime;
//        }
//
//        public void setPassTime(String passTime) {
//            this.passTime = passTime;
//        }
//
//        public int getProductChannelId() {
//            return productChannelId;
//        }
//
//        public void setProductChannelId(int productChannelId) {
//            this.productChannelId = productChannelId;
//        }
//
//        public String getProductInterestType() {
//            return productInterestType;
//        }
//
//        public void setProductInterestType(String productInterestType) {
//            this.productInterestType = productInterestType;
//        }
//
//        public String getProductName() {
//            return productName;
//        }
//
//        public void setProductName(String productName) {
//            this.productName = productName;
//        }
//
//        public String getProductStatus() {
//            return productStatus;
//        }
//
//        public void setProductStatus(String productStatus) {
//            this.productStatus = productStatus;
//        }
//
//        public String getProductStatusValue() {
//            return productStatusValue;
//        }
//
//        public void setProductStatusValue(String productStatusValue) {
//            this.productStatusValue = productStatusValue;
//        }
//
//        public String getProductTypeName() {
//            return productTypeName;
//        }
//
//        public void setProductTypeName(String productTypeName) {
//            this.productTypeName = productTypeName;
//        }
//
//        public String getProductTypeValue() {
//            return productTypeValue;
//        }
//
//        public void setProductTypeValue(String productTypeValue) {
//            this.productTypeValue = productTypeValue;
//        }
//
//        public boolean isRecommend() {
//            return recommend;
//        }
//
//        public void setRecommend(boolean recommend) {
//            this.recommend = recommend;
//        }
//
//        public int getRemainingAmount() {
//            return remainingAmount;
//        }
//
//        public void setRemainingAmount(int remainingAmount) {
//            this.remainingAmount = remainingAmount;
//        }
//
//        public int getSaleAmount() {
//            return saleAmount;
//        }
//
//        public void setSaleAmount(int saleAmount) {
//            this.saleAmount = saleAmount;
//        }
//
//        public String getSaleEndTime() {
//            return saleEndTime;
//        }
//
//        public void setSaleEndTime(String saleEndTime) {
//            this.saleEndTime = saleEndTime;
//        }
//
//        public String getSaleStartTime() {
//            return saleStartTime;
//        }
//
//        public void setSaleStartTime(String saleStartTime) {
//            this.saleStartTime = saleStartTime;
//        }
//
//        public String getStartBuyTime() {
//            return startBuyTime;
//        }
//
//        public void setStartBuyTime(String startBuyTime) {
//            this.startBuyTime = startBuyTime;
//        }
//
//        public String getStartInterestDate() {
//            return startInterestDate;
//        }
//
//        public void setStartInterestDate(String startInterestDate) {
//            this.startInterestDate = startInterestDate;
//        }
//
//        public int getTotalAmount() {
//            return totalAmount;
//        }
//
//        public void setTotalAmount(int totalAmount) {
//            this.totalAmount = totalAmount;
//        }
//
//        public int getTotalBuyNumber() {
//            return totalBuyNumber;
//        }
//
//        public void setTotalBuyNumber(int totalBuyNumber) {
//            this.totalBuyNumber = totalBuyNumber;
//        }
//
//        public int getTotalCopies() {
//            return totalCopies;
//        }
//
//        public void setTotalCopies(int totalCopies) {
//            this.totalCopies = totalCopies;
//        }
//    }

//    public static class BannerListBean {
//        /**
//         * channelId : 0
//         * createTime : 2017-10-30 14:31:11
//         * enable : true
//         * htmlTitle : 推荐有礼榜
//         * htmlURL : http://activity.xidaiw.com/event/recommendWap
//         * id : 68
//         * imageURI : http://101.37.174.8/ftp_user/banner/20171030.png
//         * name : 推荐有礼榜
//         * osType : OS_IOS_ANDROID
//         * sortParameter : 236
//         * updateTime : 2017-10-30 14:31:59
//         */
//
//        private int channelId;
//        private String createTime;
//        private boolean enable;
//        private String htmlTitle;
//        private String htmlURL;
//        private int id;
//        private String imageURI;
//        private String name;
//        private String osType;
//        private int sortParameter;
//        private String updateTime;
//
//        public static BannerListBean objectFromData(String str) {
//
//            return new com.google.gson.Gson().fromJson(str, BannerListBean.class);
//        }
//
//        public int getChannelId() {
//            return channelId;
//        }
//
//        public void setChannelId(int channelId) {
//            this.channelId = channelId;
//        }
//
//        public String getCreateTime() {
//            return createTime;
//        }
//
//        public void setCreateTime(String createTime) {
//            this.createTime = createTime;
//        }
//
//        public boolean isEnable() {
//            return enable;
//        }
//
//        public void setEnable(boolean enable) {
//            this.enable = enable;
//        }
//
//        public String getHtmlTitle() {
//            return htmlTitle;
//        }
//
//        public void setHtmlTitle(String htmlTitle) {
//            this.htmlTitle = htmlTitle;
//        }
//
//        public String getHtmlURL() {
//            return htmlURL;
//        }
//
//        public void setHtmlURL(String htmlURL) {
//            this.htmlURL = htmlURL;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getImageURI() {
//            return imageURI;
//        }
//
//        public void setImageURI(String imageURI) {
//            this.imageURI = imageURI;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getOsType() {
//            return osType;
//        }
//
//        public void setOsType(String osType) {
//            this.osType = osType;
//        }
//
//        public int getSortParameter() {
//            return sortParameter;
//        }
//
//        public void setSortParameter(int sortParameter) {
//            this.sortParameter = sortParameter;
//        }
//
//        public String getUpdateTime() {
//            return updateTime;
//        }
//
//        public void setUpdateTime(String updateTime) {
//            this.updateTime = updateTime;
//        }
//    }
}
