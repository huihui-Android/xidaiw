package xidaiw.mine.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/3/8.
 */

public class InviteFriendsInfo {

    /**
     * code : 1
     * data : {"award":5.01,"customer":{"channelId":40001,"customerSource":"MOBILE_REGISTER","enable":true,"hasPayPassword":true,"id":53277,"idCard":"420102199411130019","idCardAuth":true,"lastLoginIP":"27.17.87.183/mb","lastLoginTime":"2018-03-08 09:55:09","mobile":"15994252813","mobileAuth":true,"password":"e10adc3949ba59abbe56e057f20f883e","payPassword":"e10adc3949ba59abbe56e057f20f883e","realName":"孙昌镐","recommender":"","regTime":"2017-09-03 11:05:13","registerOSType":"OS_HOME_PC"},"total":5}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static InviteFriendsInfo objectFromData(String str) {

        return new Gson().fromJson(str, InviteFriendsInfo.class);
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
         * award : 5.01
         * customer : {"channelId":40001,"customerSource":"MOBILE_REGISTER","enable":true,"hasPayPassword":true,"id":53277,"idCard":"420102199411130019","idCardAuth":true,"lastLoginIP":"27.17.87.183/mb","lastLoginTime":"2018-03-08 09:55:09","mobile":"15994252813","mobileAuth":true,"password":"e10adc3949ba59abbe56e057f20f883e","payPassword":"e10adc3949ba59abbe56e057f20f883e","realName":"孙昌镐","recommender":"","regTime":"2017-09-03 11:05:13","registerOSType":"OS_HOME_PC"}
         * total : 5
         */

        private double award;
        private CustomerBean customer;
        private int total;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public double getAward() {
            return award;
        }

        public void setAward(double award) {
            this.award = award;
        }

        public CustomerBean getCustomer() {
            return customer;
        }

        public void setCustomer(CustomerBean customer) {
            this.customer = customer;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public static class CustomerBean {
            /**
             * channelId : 40001
             * customerSource : MOBILE_REGISTER
             * enable : true
             * hasPayPassword : true
             * id : 53277
             * idCard : 420102199411130019
             * idCardAuth : true
             * lastLoginIP : 27.17.87.183/mb
             * lastLoginTime : 2018-03-08 09:55:09
             * mobile : 15994252813
             * mobileAuth : true
             * password : e10adc3949ba59abbe56e057f20f883e
             * payPassword : e10adc3949ba59abbe56e057f20f883e
             * realName : 孙昌镐
             * recommender :
             * regTime : 2017-09-03 11:05:13
             * registerOSType : OS_HOME_PC
             */

            private int channelId;
            private String customerSource;
            private boolean enable;
            private boolean hasPayPassword;
            private int id;
            private String idCard;
            private boolean idCardAuth;
            private String lastLoginIP;
            private String lastLoginTime;
            private String mobile;
            private boolean mobileAuth;
            private String password;
            private String payPassword;
            private String realName;
            private String recommender;
            private String regTime;
            private String registerOSType;

            public static CustomerBean objectFromData(String str) {

                return new Gson().fromJson(str, CustomerBean.class);
            }

            public int getChannelId() {
                return channelId;
            }

            public void setChannelId(int channelId) {
                this.channelId = channelId;
            }

            public String getCustomerSource() {
                return customerSource;
            }

            public void setCustomerSource(String customerSource) {
                this.customerSource = customerSource;
            }

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public boolean isHasPayPassword() {
                return hasPayPassword;
            }

            public void setHasPayPassword(boolean hasPayPassword) {
                this.hasPayPassword = hasPayPassword;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIdCard() {
                return idCard;
            }

            public void setIdCard(String idCard) {
                this.idCard = idCard;
            }

            public boolean isIdCardAuth() {
                return idCardAuth;
            }

            public void setIdCardAuth(boolean idCardAuth) {
                this.idCardAuth = idCardAuth;
            }

            public String getLastLoginIP() {
                return lastLoginIP;
            }

            public void setLastLoginIP(String lastLoginIP) {
                this.lastLoginIP = lastLoginIP;
            }

            public String getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(String lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public boolean isMobileAuth() {
                return mobileAuth;
            }

            public void setMobileAuth(boolean mobileAuth) {
                this.mobileAuth = mobileAuth;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getPayPassword() {
                return payPassword;
            }

            public void setPayPassword(String payPassword) {
                this.payPassword = payPassword;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getRecommender() {
                return recommender;
            }

            public void setRecommender(String recommender) {
                this.recommender = recommender;
            }

            public String getRegTime() {
                return regTime;
            }

            public void setRegTime(String regTime) {
                this.regTime = regTime;
            }

            public String getRegisterOSType() {
                return registerOSType;
            }

            public void setRegisterOSType(String registerOSType) {
                this.registerOSType = registerOSType;
            }
        }
    }
}
