package xidaiw.mine.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/2/23.
 */

public class PersonInfo {

    /**
     * code : 1
     * data : {"ableWithdrawalAmount":"0.00","customerAccount":{"availableScore":1000,"fullIdCardStr":"420682199109166335","hasPayPwd":false,"idCardAuthi":false,"idCardNumber":"4206********6335","isBuy":false,"mobile":"18040551470","realName":"郭辉辉","realNameAuthed":true,"todayTotalEarnings":0,"totalAssets":0,"totalAvailable":"0.00","totalEarnings":0,"totalFreezen":0}}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static PersonInfo objectFromData(String str) {

        return new Gson().fromJson(str, PersonInfo.class);
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
         * ableWithdrawalAmount : 0.00
         * customerAccount : {"availableScore":1000,"fullIdCardStr":"420682199109166335","hasPayPwd":false,"idCardAuthi":false,"idCardNumber":"4206********6335","isBuy":false,"mobile":"18040551470","realName":"郭辉辉","realNameAuthed":true,"todayTotalEarnings":0,"totalAssets":0,"totalAvailable":"0.00","totalEarnings":0,"totalFreezen":0}
         */

        private String ableWithdrawalAmount;
        private CustomerAccountBean customerAccount;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public String getAbleWithdrawalAmount() {
            return ableWithdrawalAmount;
        }

        public void setAbleWithdrawalAmount(String ableWithdrawalAmount) {
            this.ableWithdrawalAmount = ableWithdrawalAmount;
        }

        public CustomerAccountBean getCustomerAccount() {
            return customerAccount;
        }

        public void setCustomerAccount(CustomerAccountBean customerAccount) {
            this.customerAccount = customerAccount;
        }

        public static class CustomerAccountBean {
            /**
             * availableScore : 1000
             * fullIdCardStr : 420682199109166335
             * hasPayPwd : false
             * idCardAuthi : false
             * idCardNumber : 4206********6335
             * isBuy : false
             * mobile : 18040551470
             * realName : 郭辉辉
             * realNameAuthed : true
             * todayTotalEarnings : 0
             * totalAssets : 0
             * totalAvailable : 0.00
             * totalEarnings : 0
             * totalFreezen : 0
             */

            private int availableScore;
            private String fullIdCardStr;
            private boolean hasPayPwd;
            private boolean idCardAuthi;
            private String idCardNumber;
            private boolean isBuy;
            private String mobile;
            private String realName;
            private boolean realNameAuthed;
            private String todayTotalEarnings;
            private double totalAssets;
            private String totalAvailable;
            private String totalEarnings;
            private String totalFreezen;

            public static CustomerAccountBean objectFromData(String str) {

                return new Gson().fromJson(str, CustomerAccountBean.class);
            }

            public int getAvailableScore() {
                return availableScore;
            }

            public void setAvailableScore(int availableScore) {
                this.availableScore = availableScore;
            }

            public String getFullIdCardStr() {
                return fullIdCardStr;
            }

            public void setFullIdCardStr(String fullIdCardStr) {
                this.fullIdCardStr = fullIdCardStr;
            }

            public boolean isHasPayPwd() {
                return hasPayPwd;
            }

            public void setHasPayPwd(boolean hasPayPwd) {
                this.hasPayPwd = hasPayPwd;
            }

            public boolean isIdCardAuthi() {
                return idCardAuthi;
            }

            public void setIdCardAuthi(boolean idCardAuthi) {
                this.idCardAuthi = idCardAuthi;
            }

            public String getIdCardNumber() {
                return idCardNumber;
            }

            public void setIdCardNumber(String idCardNumber) {
                this.idCardNumber = idCardNumber;
            }

            public boolean isIsBuy() {
                return isBuy;
            }

            public void setIsBuy(boolean isBuy) {
                this.isBuy = isBuy;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public boolean isRealNameAuthed() {
                return realNameAuthed;
            }

            public void setRealNameAuthed(boolean realNameAuthed) {
                this.realNameAuthed = realNameAuthed;
            }

            public String getTodayTotalEarnings() {
                return todayTotalEarnings;
            }

            public void setTodayTotalEarnings(String todayTotalEarnings) {
                this.todayTotalEarnings = todayTotalEarnings;
            }

            public double getTotalAssets() {
                return totalAssets;
            }

            public void setTotalAssets(double totalAssets) {
                this.totalAssets = totalAssets;
            }

            public String getTotalAvailable() {
                return totalAvailable;
            }

            public void setTotalAvailable(String totalAvailable) {
                this.totalAvailable = totalAvailable;
            }

            public String getTotalEarnings() {
                return totalEarnings;
            }

            public void setTotalEarnings(String totalEarnings) {
                this.totalEarnings = totalEarnings;
            }

            public String getTotalFreezen() {
                return totalFreezen;
            }

            public void setTotalFreezen(String totalFreezen) {
                this.totalFreezen = totalFreezen;
            }
        }
    }
}
