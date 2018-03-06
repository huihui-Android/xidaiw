package xidaiw.mine.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/3/6.
 */

public class WithdrawRecordInfo {

    /**
     * code : 1
     * data : {"list":[{"again":false,"amount":337.45,"applyTime":"2018-03-05 15:51:26","auditStaffId":0,"customerId":0,"customerSubAccountId":53224,"id":610,"mobile":"15994252813","realName":"孙昌镐","status":"AUDITING","statusValue":"审核中","type":"CUSTOMER_APPLY_HANDLE","typeValue":"投资用户申请提现","withdrawalStaffId":0}],"total":26}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static WithdrawRecordInfo objectFromData(String str) {

        return new Gson().fromJson(str, WithdrawRecordInfo.class);
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
         * list : [{"again":false,"amount":337.45,"applyTime":"2018-03-05 15:51:26","auditStaffId":0,"customerId":0,"customerSubAccountId":53224,"id":610,"mobile":"15994252813","realName":"孙昌镐","status":"AUDITING","statusValue":"审核中","type":"CUSTOMER_APPLY_HANDLE","typeValue":"投资用户申请提现","withdrawalStaffId":0}]
         * total : 26
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
             * again : false
             * amount : 337.45
             * applyTime : 2018-03-05 15:51:26
             * auditStaffId : 0
             * customerId : 0
             * customerSubAccountId : 53224
             * id : 610
             * mobile : 15994252813
             * realName : 孙昌镐
             * status : AUDITING
             * statusValue : 审核中
             * type : CUSTOMER_APPLY_HANDLE
             * typeValue : 投资用户申请提现
             * withdrawalStaffId : 0
             */

            private boolean again;
            private double amount;
            private String applyTime;
            private int auditStaffId;
            private int customerId;
            private int customerSubAccountId;
            private int id;
            private String mobile;
            private String realName;
            private String status;
            private String statusValue;
            private String type;
            private String typeValue;
            private int withdrawalStaffId;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public boolean isAgain() {
                return again;
            }

            public void setAgain(boolean again) {
                this.again = again;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public String getApplyTime() {
                return applyTime;
            }

            public void setApplyTime(String applyTime) {
                this.applyTime = applyTime;
            }

            public int getAuditStaffId() {
                return auditStaffId;
            }

            public void setAuditStaffId(int auditStaffId) {
                this.auditStaffId = auditStaffId;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTypeValue() {
                return typeValue;
            }

            public void setTypeValue(String typeValue) {
                this.typeValue = typeValue;
            }

            public int getWithdrawalStaffId() {
                return withdrawalStaffId;
            }

            public void setWithdrawalStaffId(int withdrawalStaffId) {
                this.withdrawalStaffId = withdrawalStaffId;
            }
        }
    }
}
