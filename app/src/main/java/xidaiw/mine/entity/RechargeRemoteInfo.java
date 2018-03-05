package xidaiw.mine.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/3/5.
 */

public class RechargeRemoteInfo {

    /**
     * code : 1
     * message : 成功
     * success : true
     * data : {"relativeUrl":"pay/wap/reapal4wap/request?amount=100.0&customerId=53277&productChannelId=2&userBankCardId=52","payWay":"WAP","url":"http://mobile.xidaiw.com/mobile/pay/wap/reapal4wap/request?amount=100.0&customerId=53277&productChannelId=2&userBankCardId=52"}
     */

    private int code;
    private String message;
    private boolean success;
    private DataBean data;

    public static RechargeRemoteInfo objectFromData(String str) {

        return new Gson().fromJson(str, RechargeRemoteInfo.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * relativeUrl : pay/wap/reapal4wap/request?amount=100.0&customerId=53277&productChannelId=2&userBankCardId=52
         * payWay : WAP
         * url : http://mobile.xidaiw.com/mobile/pay/wap/reapal4wap/request?amount=100.0&customerId=53277&productChannelId=2&userBankCardId=52
         */

        private String relativeUrl;
        private String payWay;
        private String url;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public String getRelativeUrl() {
            return relativeUrl;
        }

        public void setRelativeUrl(String relativeUrl) {
            this.relativeUrl = relativeUrl;
        }

        public String getPayWay() {
            return payWay;
        }

        public void setPayWay(String payWay) {
            this.payWay = payWay;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
