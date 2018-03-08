package xidaiw.licai.bean;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/2/5.
 */

public class Loan1 {

    /**
     * activityDescription :
     * appshouDesciption : app
     * awardInterest : 3
     * baseAmount : 100
     * canJoin : true
     * canJoinCode : 0
     * cornerType : ACTIVITY
     * descriptionTitle : 车辆抵押
     * endBuyTime : 24时0分
     * finishRatio : 0
     * id : 609
     * idStr : SSSSoSc2f
     * interest : 12.8
     * maturityDuration : 180天
     * maxAmount : 650
     * maxInterest : 12.8
     * minAmount : 1
     * minInterest : 12.8
     * normalInterest : 9.8
     * productChannelId : 2
     * productInterestType : 固定收益
     * productName : 丰田抵押借款 第393期
     * productStatus : SALES
     * productStatusValue : 销售中
     * productTypeName : 常规固定期限产品
     * productTypeValue : FIXED_TERM_PRODUCT
     * recommend : false
     * remainingAmount : 650
     * saleAmount : 0
     * saleEndTime : 2018-02-08 00:00:00
     * saleStartTime : 2018-02-05 11:13:39
     * startBuyTime : 0时0分
     * totalAmount : 65000
     * totalBuyNumber : 0
     * totalCopies : 650
     */

    private String activityDescription;
    private String appshouDesciption;
    private int awardInterest;
    private int baseAmount;
    private boolean canJoin;
    private int canJoinCode;
    private String cornerType;
    private String descriptionTitle;
    private String endBuyTime;
    private int finishRatio;
    private int id;
    private String idStr;
    private double interest;
    private String maturityDuration;
    private int maxAmount;
    private double maxInterest;
    private int minAmount;
    private double minInterest;
    private double normalInterest;
    private int productChannelId;
    private String productInterestType;
    private String productName;
    private String productStatus;
    private String productStatusValue;
    private String productTypeName;
    private String productTypeValue;
    private boolean recommend;
    private int remainingAmount;
    private int saleAmount;
    private String saleEndTime;
    private String saleStartTime;
    private String startBuyTime;
    private int totalAmount;
    private int totalBuyNumber;
    private int totalCopies;

    public static Loan1 objectFromData(String str) {

        return new Gson().fromJson(str, Loan1.class);
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getAppshouDesciption() {
        return appshouDesciption;
    }

    public void setAppshouDesciption(String appshouDesciption) {
        this.appshouDesciption = appshouDesciption;
    }

    public int getAwardInterest() {
        return awardInterest;
    }

    public void setAwardInterest(int awardInterest) {
        this.awardInterest = awardInterest;
    }

    public int getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(int baseAmount) {
        this.baseAmount = baseAmount;
    }

    public boolean isCanJoin() {
        return canJoin;
    }

    public void setCanJoin(boolean canJoin) {
        this.canJoin = canJoin;
    }

    public int getCanJoinCode() {
        return canJoinCode;
    }

    public void setCanJoinCode(int canJoinCode) {
        this.canJoinCode = canJoinCode;
    }

    public String getCornerType() {
        return cornerType;
    }

    public void setCornerType(String cornerType) {
        this.cornerType = cornerType;
    }

    public String getDescriptionTitle() {
        return descriptionTitle;
    }

    public void setDescriptionTitle(String descriptionTitle) {
        this.descriptionTitle = descriptionTitle;
    }

    public String getEndBuyTime() {
        return endBuyTime;
    }

    public void setEndBuyTime(String endBuyTime) {
        this.endBuyTime = endBuyTime;
    }

    public int getFinishRatio() {
        return finishRatio;
    }

    public void setFinishRatio(int finishRatio) {
        this.finishRatio = finishRatio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public String getMaturityDuration() {
        return maturityDuration;
    }

    public void setMaturityDuration(String maturityDuration) {
        this.maturityDuration = maturityDuration;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getMaxInterest() {
        return maxInterest;
    }

    public void setMaxInterest(double maxInterest) {
        this.maxInterest = maxInterest;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public double getMinInterest() {
        return minInterest;
    }

    public void setMinInterest(double minInterest) {
        this.minInterest = minInterest;
    }

    public double getNormalInterest() {
        return normalInterest;
    }

    public void setNormalInterest(double normalInterest) {
        this.normalInterest = normalInterest;
    }

    public int getProductChannelId() {
        return productChannelId;
    }

    public void setProductChannelId(int productChannelId) {
        this.productChannelId = productChannelId;
    }

    public String getProductInterestType() {
        return productInterestType;
    }

    public void setProductInterestType(String productInterestType) {
        this.productInterestType = productInterestType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusValue() {
        return productStatusValue;
    }

    public void setProductStatusValue(String productStatusValue) {
        this.productStatusValue = productStatusValue;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeValue() {
        return productTypeValue;
    }

    public void setProductTypeValue(String productTypeValue) {
        this.productTypeValue = productTypeValue;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public int getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(int remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getSaleEndTime() {
        return saleEndTime;
    }

    public void setSaleEndTime(String saleEndTime) {
        this.saleEndTime = saleEndTime;
    }

    public String getSaleStartTime() {
        return saleStartTime;
    }

    public void setSaleStartTime(String saleStartTime) {
        this.saleStartTime = saleStartTime;
    }

    public String getStartBuyTime() {
        return startBuyTime;
    }

    public void setStartBuyTime(String startBuyTime) {
        this.startBuyTime = startBuyTime;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalBuyNumber() {
        return totalBuyNumber;
    }

    public void setTotalBuyNumber(int totalBuyNumber) {
        this.totalBuyNumber = totalBuyNumber;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }
}
