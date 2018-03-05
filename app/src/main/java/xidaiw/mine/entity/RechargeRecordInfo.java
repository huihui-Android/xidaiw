package xidaiw.mine.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/3/5.
 */

public class RechargeRecordInfo {

    /**
     * code : 1
     * data : {"list":[{"amount":50,"arriveTime":"2018-02-07 11:06:29","createTime":"2018-02-07 11:00:29","customerId":53277,"customerSubAccountId":53224,"fee":1,"id":64340,"mobile":"15994252813","productChannelId":2,"realFeeCostAccount":2,"realName":"孙昌镐","status":"RECHARGE_SUCCESS","statusValue":"充值成功","successAmount":50},{"amount":100,"createTime":"2018-02-07 10:03:15","customerId":53277,"customerSubAccountId":53224,"fee":0,"id":64339,"mobile":"15994252813","productChannelId":2,"realFeeCostAccount":0,"realName":"孙昌镐","status":"WAITING_PAY","statusValue":"等待支付","successAmount":0}],"total":103}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static RechargeRecordInfo objectFromData(String str) {

        return new Gson().fromJson(str, RechargeRecordInfo.class);
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
         * list : [{"amount":50,"arriveTime":"2018-02-07 11:06:29","createTime":"2018-02-07 11:00:29","customerId":53277,"customerSubAccountId":53224,"fee":1,"id":64340,"mobile":"15994252813","productChannelId":2,"realFeeCostAccount":2,"realName":"孙昌镐","status":"RECHARGE_SUCCESS","statusValue":"充值成功","successAmount":50},{"amount":100,"createTime":"2018-02-07 10:03:15","customerId":53277,"customerSubAccountId":53224,"fee":0,"id":64339,"mobile":"15994252813","productChannelId":2,"realFeeCostAccount":0,"realName":"孙昌镐","status":"WAITING_PAY","statusValue":"等待支付","successAmount":0}]
         * total : 103
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
             * amount : 50
             * arriveTime : 2018-02-07 11:06:29
             * createTime : 2018-02-07 11:00:29
             * customerId : 53277
             * customerSubAccountId : 53224
             * fee : 1
             * id : 64340
             * mobile : 15994252813
             * productChannelId : 2
             * realFeeCostAccount : 2
             * realName : 孙昌镐
             * status : RECHARGE_SUCCESS
             * statusValue : 充值成功
             * successAmount : 50
             */

            private int amount;
            private String arriveTime;
            private String createTime;
            private int customerId;
            private int customerSubAccountId;
            private int fee;
            private int id;
            private String mobile;
            private int productChannelId;
            private int realFeeCostAccount;
            private String realName;
            private String status;
            private String statusValue;
            private int successAmount;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getArriveTime() {
                return arriveTime;
            }

            public void setArriveTime(String arriveTime) {
                this.arriveTime = arriveTime;
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

            public int getCustomerSubAccountId() {
                return customerSubAccountId;
            }

            public void setCustomerSubAccountId(int customerSubAccountId) {
                this.customerSubAccountId = customerSubAccountId;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public int getProductChannelId() {
                return productChannelId;
            }

            public void setProductChannelId(int productChannelId) {
                this.productChannelId = productChannelId;
            }

            public int getRealFeeCostAccount() {
                return realFeeCostAccount;
            }

            public void setRealFeeCostAccount(int realFeeCostAccount) {
                this.realFeeCostAccount = realFeeCostAccount;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStatusValue() {
                return statusValue;
            }

            public void setStatusValue(String statusValue) {
                this.statusValue = statusValue;
            }

            public int getSuccessAmount() {
                return successAmount;
            }

            public void setSuccessAmount(int successAmount) {
                this.successAmount = successAmount;
            }
        }
    }
}
