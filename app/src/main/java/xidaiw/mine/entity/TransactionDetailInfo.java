package xidaiw.mine.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/3/7.
 */

public class TransactionDetailInfo {

    /**
     * code : 1
     * data : {"ableWithdrawalAmount":"0.00","customerAccount":{"availableScore":1850,"fullIdCardStr":"420102199411130019","hasPayPwd":true,"idCardAuthi":false,"idCardNumber":"4201********0019","isBuy":false,"mobile":"15994252813","realName":"孙昌镐","realNameAuthed":true,"todayTotalEarnings":0,"totalAssets":0,"totalAvailable":"0.00","totalEarnings":174.5592,"totalFreezen":0},"list":[{"amount":337.45,"availableAmount":0,"createTime":"2018-03-06 09:30:02","customerId":53277,"customerPointTypeName":"提现成功","id":19955,"plus":false,"pointColorType":3},{"amount":200,"availableAmount":357.77,"createTime":"2017-09-30 06:00:06","customerId":53277,"customerPointTypeName":"还款本金","id":4720,"plus":true,"pointColorType":1}]}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static TransactionDetailInfo objectFromData(String str) {

        return new Gson().fromJson(str, TransactionDetailInfo.class);
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
         * customerAccount : {"availableScore":1850,"fullIdCardStr":"420102199411130019","hasPayPwd":true,"idCardAuthi":false,"idCardNumber":"4201********0019","isBuy":false,"mobile":"15994252813","realName":"孙昌镐","realNameAuthed":true,"todayTotalEarnings":0,"totalAssets":0,"totalAvailable":"0.00","totalEarnings":174.5592,"totalFreezen":0}
         * list : [{"amount":337.45,"availableAmount":0,"createTime":"2018-03-06 09:30:02","customerId":53277,"customerPointTypeName":"提现成功","id":19955,"plus":false,"pointColorType":3},{"amount":200,"availableAmount":357.77,"createTime":"2017-09-30 06:00:06","customerId":53277,"customerPointTypeName":"还款本金","id":4720,"plus":true,"pointColorType":1}]
         */

        private String ableWithdrawalAmount;
        private CustomerAccountBean customerAccount;
        private List<ListBean> list;

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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class CustomerAccountBean {
            /**
             * availableScore : 1850
             * fullIdCardStr : 420102199411130019
             * hasPayPwd : true
             * idCardAuthi : false
             * idCardNumber : 4201********0019
             * isBuy : false
             * mobile : 15994252813
             * realName : 孙昌镐
             * realNameAuthed : true
             * todayTotalEarnings : 0
             * totalAssets : 0
             * totalAvailable : 0.00
             * totalEarnings : 174.5592
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
            private int todayTotalEarnings;
            private int totalAssets;
            private String totalAvailable;
            private double totalEarnings;
            private int totalFreezen;

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

            public int getTodayTotalEarnings() {
                return todayTotalEarnings;
            }

            public void setTodayTotalEarnings(int todayTotalEarnings) {
                this.todayTotalEarnings = todayTotalEarnings;
            }

            public int getTotalAssets() {
                return totalAssets;
            }

            public void setTotalAssets(int totalAssets) {
                this.totalAssets = totalAssets;
            }

            public String getTotalAvailable() {
                return totalAvailable;
            }

            public void setTotalAvailable(String totalAvailable) {
                this.totalAvailable = totalAvailable;
            }

            public double getTotalEarnings() {
                return totalEarnings;
            }

            public void setTotalEarnings(double totalEarnings) {
                this.totalEarnings = totalEarnings;
            }

            public int getTotalFreezen() {
                return totalFreezen;
            }

            public void setTotalFreezen(int totalFreezen) {
                this.totalFreezen = totalFreezen;
            }
        }

        public static class ListBean {
            /**
             * amount : 337.45
             * availableAmount : 0
             * createTime : 2018-03-06 09:30:02
             * customerId : 53277
             * customerPointTypeName : 提现成功
             * id : 19955
             * plus : false
             * pointColorType : 3
             */

            private double amount;
            private int availableAmount;
            private String createTime;
            private int customerId;
            private String customerPointTypeName;
            private int id;
            private boolean plus;
            private int pointColorType;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public int getAvailableAmount() {
                return availableAmount;
            }

            public void setAvailableAmount(int availableAmount) {
                this.availableAmount = availableAmount;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getCustomerId() {
                return customerId;
            }

            public void setCustomerId(int customerId) {
                this.customerId = customerId;
            }

            public String getCustomerPointTypeName() {
                return customerPointTypeName;
            }

            public void setCustomerPointTypeName(String customerPointTypeName) {
                this.customerPointTypeName = customerPointTypeName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isPlus() {
                return plus;
            }

            public void setPlus(boolean plus) {
                this.plus = plus;
            }

            public int getPointColorType() {
                return pointColorType;
            }

            public void setPointColorType(int pointColorType) {
                this.pointColorType = pointColorType;
            }
        }
    }
}
