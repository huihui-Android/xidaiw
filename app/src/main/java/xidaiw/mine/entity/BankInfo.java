package xidaiw.mine.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/3/2.
 */

public class BankInfo {

    /**
     * code : 1
     * data : {"list":[{"bankBranchName":"招商银行皇岗支行","bankCardNumber":"4666","bankCityCode":"440300","bankDayLimit":50000,"bankHDPicPath":"bank/1421169992718.png","bankId":52,"bankName":"招商银行","bankPicPath":"http://101.37.174.8/ftp_user/bank/1421169992718.png","bankTimeLimit":20000,"enable":true,"fullBankCardNumber":"6214866554594666","id":11611,"payChannelId":6,"statusName":"BINDED","statusValue":"已经绑定"}],"total":1}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static BankInfo objectFromData(String str) {

        return new Gson().fromJson(str, BankInfo.class);
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
         * list : [{"bankBranchName":"招商银行皇岗支行","bankCardNumber":"4666","bankCityCode":"440300","bankDayLimit":50000,"bankHDPicPath":"bank/1421169992718.png","bankId":52,"bankName":"招商银行","bankPicPath":"http://101.37.174.8/ftp_user/bank/1421169992718.png","bankTimeLimit":20000,"enable":true,"fullBankCardNumber":"6214866554594666","id":11611,"payChannelId":6,"statusName":"BINDED","statusValue":"已经绑定"}]
         * total : 1
         */

        private int total;
        private List<ListBean> list;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * bankBranchName : 招商银行皇岗支行
             * bankCardNumber : 4666
             * bankCityCode : 440300
             * bankDayLimit : 50000
             * bankHDPicPath : bank/1421169992718.png
             * bankId : 52
             * bankName : 招商银行
             * bankPicPath : http://101.37.174.8/ftp_user/bank/1421169992718.png
             * bankTimeLimit : 20000
             * enable : true
             * fullBankCardNumber : 6214866554594666
             * id : 11611
             * payChannelId : 6
             * statusName : BINDED
             * statusValue : 已经绑定
             */

            private String bankBranchName;
            private String bankCardNumber;
            private String bankCityCode;
            private int bankDayLimit;
            private String bankHDPicPath;
            private int bankId;
            private String bankName;
            private String bankPicPath;
            private int bankTimeLimit;
            private boolean enable;
            private String fullBankCardNumber;
            private int id;
            private int payChannelId;
            private String statusName;
            private String statusValue;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public String getBankBranchName() {
                return bankBranchName;
            }

            public void setBankBranchName(String bankBranchName) {
                this.bankBranchName = bankBranchName;
            }

            public String getBankCardNumber() {
                return bankCardNumber;
            }

            public void setBankCardNumber(String bankCardNumber) {
                this.bankCardNumber = bankCardNumber;
            }

            public String getBankCityCode() {
                return bankCityCode;
            }

            public void setBankCityCode(String bankCityCode) {
                this.bankCityCode = bankCityCode;
            }

            public int getBankDayLimit() {
                return bankDayLimit;
            }

            public void setBankDayLimit(int bankDayLimit) {
                this.bankDayLimit = bankDayLimit;
            }

            public String getBankHDPicPath() {
                return bankHDPicPath;
            }

            public void setBankHDPicPath(String bankHDPicPath) {
                this.bankHDPicPath = bankHDPicPath;
            }

            public int getBankId() {
                return bankId;
            }

            public void setBankId(int bankId) {
                this.bankId = bankId;
            }

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public String getBankPicPath() {
                return bankPicPath;
            }

            public void setBankPicPath(String bankPicPath) {
                this.bankPicPath = bankPicPath;
            }

            public int getBankTimeLimit() {
                return bankTimeLimit;
            }

            public void setBankTimeLimit(int bankTimeLimit) {
                this.bankTimeLimit = bankTimeLimit;
            }

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public String getFullBankCardNumber() {
                return fullBankCardNumber;
            }

            public void setFullBankCardNumber(String fullBankCardNumber) {
                this.fullBankCardNumber = fullBankCardNumber;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPayChannelId() {
                return payChannelId;
            }

            public void setPayChannelId(int payChannelId) {
                this.payChannelId = payChannelId;
            }

            public String getStatusName() {
                return statusName;
            }

            public void setStatusName(String statusName) {
                this.statusName = statusName;
            }

            public String getStatusValue() {
                return statusValue;
            }

            public void setStatusValue(String statusValue) {
                this.statusValue = statusValue;
            }
        }
    }
}
