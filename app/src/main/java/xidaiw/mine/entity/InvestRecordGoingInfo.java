package xidaiw.mine.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/3/7.
 */

public class InvestRecordGoingInfo {

    /**
     * code : 1
     * data : {"currPlanType":"currPlan","productAccountList":[{"buyTime":"2018-02-05","id":1006,"productChannelId":2,"productId":611,"productName":"奥迪抵押借款 第395期","remainingDay":0,"todayTotalEarnings":10.6849,"totalBuyAmount":50000,"totalEarnings":309.86},{"buyTime":"2018-02-04","id":990,"productChannelId":2,"productId":604,"productName":"宝马抵押借款 第388期","remainingDay":0,"todayTotalEarnings":17.0959,"totalBuyAmount":80000,"totalEarnings":495.78}]}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static InvestRecordGoingInfo objectFromData(String str) {

        return new Gson().fromJson(str, InvestRecordGoingInfo.class);
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

    public static class DataBean {
        /**
         * currPlanType : currPlan
         * productAccountList : [{"buyTime":"2018-02-05","id":1006,"productChannelId":2,"productId":611,"productName":"奥迪抵押借款 第395期","remainingDay":0,"todayTotalEarnings":10.6849,"totalBuyAmount":50000,"totalEarnings":309.86},{"buyTime":"2018-02-04","id":990,"productChannelId":2,"productId":604,"productName":"宝马抵押借款 第388期","remainingDay":0,"todayTotalEarnings":17.0959,"totalBuyAmount":80000,"totalEarnings":495.78}]
         */

        private String currPlanType;
        private List<ProductAccountListBean> productAccountList;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public String getCurrPlanType() {
            return currPlanType;
        }

        public void setCurrPlanType(String currPlanType) {
            this.currPlanType = currPlanType;
        }

        public List<ProductAccountListBean> getProductAccountList() {
            return productAccountList;
        }

        public void setProductAccountList(List<ProductAccountListBean> productAccountList) {
            this.productAccountList = productAccountList;
        }

        public static class ProductAccountListBean {
            /**
             * buyTime : 2018-02-05
             * id : 1006
             * productChannelId : 2
             * productId : 611
             * productName : 奥迪抵押借款 第395期
             * remainingDay : 0
             * todayTotalEarnings : 10.6849
             * totalBuyAmount : 50000
             * totalEarnings : 309.86
             */

            private String buyTime;
            private int id;
            private int productChannelId;
            private int productId;
            private String productName;
            private int remainingDay;
            private double todayTotalEarnings;
            private int totalBuyAmount;
            private double totalEarnings;

            public static ProductAccountListBean objectFromData(String str) {

                return new Gson().fromJson(str, ProductAccountListBean.class);
            }

            public String getBuyTime() {
                return buyTime;
            }

            public void setBuyTime(String buyTime) {
                this.buyTime = buyTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProductChannelId() {
                return productChannelId;
            }

            public void setProductChannelId(int productChannelId) {
                this.productChannelId = productChannelId;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public int getRemainingDay() {
                return remainingDay;
            }

            public void setRemainingDay(int remainingDay) {
                this.remainingDay = remainingDay;
            }

            public double getTodayTotalEarnings() {
                return todayTotalEarnings;
            }

            public void setTodayTotalEarnings(double todayTotalEarnings) {
                this.todayTotalEarnings = todayTotalEarnings;
            }

            public int getTotalBuyAmount() {
                return totalBuyAmount;
            }

            public void setTotalBuyAmount(int totalBuyAmount) {
                this.totalBuyAmount = totalBuyAmount;
            }

            public double getTotalEarnings() {
                return totalEarnings;
            }

            public void setTotalEarnings(double totalEarnings) {
                this.totalEarnings = totalEarnings;
            }
        }
    }
}
