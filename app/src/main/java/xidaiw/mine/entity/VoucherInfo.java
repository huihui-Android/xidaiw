package xidaiw.mine.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/3/7.
 */

public class VoucherInfo {

    /**
     * code : 1
     * data : {"list":[{"days":45,"enable":true,"endDate":"2018-04-12","expire":false,"startDate":"2018-02-26","ticketEnableStatus":"启用","ticketId":87,"ticketName":"新手福利688元【满100000】【活动标可用】","ticketType":"代金券","ticketUseStatus":"未使用","useCode":"DJQ_9JqM34nws808","useLimit":100000,"userTicketId":354929,"value":688},{"days":45,"enable":true,"endDate":"2018-04-12","expire":false,"startDate":"2018-02-26","ticketEnableStatus":"启用","ticketId":84,"ticketName":"新手福利100元【满20000】【活动标可用】","ticketType":"代金券","ticketUseStatus":"未使用","useCode":"DJQ_yTHr7sP45jc8","useLimit":20000,"userTicketId":354926,"value":100}]}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static VoucherInfo objectFromData(String str) {

        return new Gson().fromJson(str, VoucherInfo.class);
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
        private List<ListBean> list;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * days : 45
             * enable : true
             * endDate : 2018-04-12
             * expire : false
             * startDate : 2018-02-26
             * ticketEnableStatus : 启用
             * ticketId : 87
             * ticketName : 新手福利688元【满100000】【活动标可用】
             * ticketType : 代金券
             * ticketUseStatus : 未使用
             * useCode : DJQ_9JqM34nws808
             * useLimit : 100000
             * userTicketId : 354929
             * value : 688
             */

            private int days;
            private boolean enable;
            private String endDate;
            private boolean expire;
            private String startDate;
            private String ticketEnableStatus;
            private int ticketId;
            private String ticketName;
            private String ticketType;
            private String ticketUseStatus;
            private String useCode;
            private int useLimit;
            private int userTicketId;
            private int value;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public int getDays() {
                return days;
            }

            public void setDays(int days) {
                this.days = days;
            }

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public boolean isExpire() {
                return expire;
            }

            public void setExpire(boolean expire) {
                this.expire = expire;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getTicketEnableStatus() {
                return ticketEnableStatus;
            }

            public void setTicketEnableStatus(String ticketEnableStatus) {
                this.ticketEnableStatus = ticketEnableStatus;
            }

            public int getTicketId() {
                return ticketId;
            }

            public void setTicketId(int ticketId) {
                this.ticketId = ticketId;
            }

            public String getTicketName() {
                return ticketName;
            }

            public void setTicketName(String ticketName) {
                this.ticketName = ticketName;
            }

            public String getTicketType() {
                return ticketType;
            }

            public void setTicketType(String ticketType) {
                this.ticketType = ticketType;
            }

            public String getTicketUseStatus() {
                return ticketUseStatus;
            }

            public void setTicketUseStatus(String ticketUseStatus) {
                this.ticketUseStatus = ticketUseStatus;
            }

            public String getUseCode() {
                return useCode;
            }

            public void setUseCode(String useCode) {
                this.useCode = useCode;
            }

            public int getUseLimit() {
                return useLimit;
            }

            public void setUseLimit(int useLimit) {
                this.useLimit = useLimit;
            }

            public int getUserTicketId() {
                return userTicketId;
            }

            public void setUserTicketId(int userTicketId) {
                this.userTicketId = userTicketId;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
    }
}
