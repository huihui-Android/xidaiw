package xidaiw.mine.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/3/6.
 */

public class RedPacketInfo {

    /**
     * code : 1
     * data : {"list":[{"code":"HB_RQj9Xe2YR45V","createTime":"2017-11-06 09:05:43","customerId":53277,"denomination":"DJQ_200","endDate":"2017-11-18 23:59:59","endDateStr":"2017-11-18","extendChannelId":2,"id":347523,"mobile":"15994252813","startDate":"2017-11-13 10:44:50","startDateStr":"2017-11-13","ticket":{"createTime":"2017-11-06 09:05:43","creatorId":1,"creatorName":"admin","days":5,"endTime":"2066-03-26 23:59:59","extendChannelId":2,"giveType":"MANUAL_RECEIVE","giveTypeValue":"手动领取","id":103,"isSecular":true,"name":"推荐有礼榜 现金红包奖励","ticketEnableStatus":"ENABLE","ticketEnableStatusValue":"启用","ticketType":"BONUS_TICKET","ticketTypeValue":"红包","userLowLimit":0,"version":1},"ticketEnableStatus":"ENABLE","ticketReceiveStatus":"RECEIVED","ticketType":"BONUS_TICKET","ticketUseStatus":"USED","useTime":"2017-11-13 12:54:42","value":200,"version":1}],"total":1}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static RedPacketInfo objectFromData(String str) {

        return new Gson().fromJson(str, RedPacketInfo.class);
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
         * list : [{"code":"HB_RQj9Xe2YR45V","createTime":"2017-11-06 09:05:43","customerId":53277,"denomination":"DJQ_200","endDate":"2017-11-18 23:59:59","endDateStr":"2017-11-18","extendChannelId":2,"id":347523,"mobile":"15994252813","startDate":"2017-11-13 10:44:50","startDateStr":"2017-11-13","ticket":{"createTime":"2017-11-06 09:05:43","creatorId":1,"creatorName":"admin","days":5,"endTime":"2066-03-26 23:59:59","extendChannelId":2,"giveType":"MANUAL_RECEIVE","giveTypeValue":"手动领取","id":103,"isSecular":true,"name":"推荐有礼榜 现金红包奖励","ticketEnableStatus":"ENABLE","ticketEnableStatusValue":"启用","ticketType":"BONUS_TICKET","ticketTypeValue":"红包","userLowLimit":0,"version":1},"ticketEnableStatus":"ENABLE","ticketReceiveStatus":"RECEIVED","ticketType":"BONUS_TICKET","ticketUseStatus":"USED","useTime":"2017-11-13 12:54:42","value":200,"version":1}]
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
             * code : HB_RQj9Xe2YR45V
             * createTime : 2017-11-06 09:05:43
             * customerId : 53277
             * denomination : DJQ_200
             * endDate : 2017-11-18 23:59:59
             * endDateStr : 2017-11-18
             * extendChannelId : 2
             * id : 347523
             * mobile : 15994252813
             * startDate : 2017-11-13 10:44:50
             * startDateStr : 2017-11-13
             * ticket : {"createTime":"2017-11-06 09:05:43","creatorId":1,"creatorName":"admin","days":5,"endTime":"2066-03-26 23:59:59","extendChannelId":2,"giveType":"MANUAL_RECEIVE","giveTypeValue":"手动领取","id":103,"isSecular":true,"name":"推荐有礼榜 现金红包奖励","ticketEnableStatus":"ENABLE","ticketEnableStatusValue":"启用","ticketType":"BONUS_TICKET","ticketTypeValue":"红包","userLowLimit":0,"version":1}
             * ticketEnableStatus : ENABLE
             * ticketReceiveStatus : RECEIVED
             * ticketType : BONUS_TICKET
             * ticketUseStatus : USED
             * useTime : 2017-11-13 12:54:42
             * value : 200
             * version : 1
             */

            private String code;
            private String createTime;
            private int customerId;
            private String denomination;
            private String endDate;
            private String endDateStr;
            private int extendChannelId;
            private int id;
            private String mobile;
            private String startDate;
            private String startDateStr;
            private TicketBean ticket;
            private String ticketEnableStatus;
            private String ticketReceiveStatus;
            private String ticketType;
            private String ticketUseStatus;
            private String useTime;
            private int value;
            private int version;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
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

            public String getDenomination() {
                return denomination;
            }

            public void setDenomination(String denomination) {
                this.denomination = denomination;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public String getEndDateStr() {
                return endDateStr;
            }

            public void setEndDateStr(String endDateStr) {
                this.endDateStr = endDateStr;
            }

            public int getExtendChannelId() {
                return extendChannelId;
            }

            public void setExtendChannelId(int extendChannelId) {
                this.extendChannelId = extendChannelId;
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

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getStartDateStr() {
                return startDateStr;
            }

            public void setStartDateStr(String startDateStr) {
                this.startDateStr = startDateStr;
            }

            public TicketBean getTicket() {
                return ticket;
            }

            public void setTicket(TicketBean ticket) {
                this.ticket = ticket;
            }

            public String getTicketEnableStatus() {
                return ticketEnableStatus;
            }

            public void setTicketEnableStatus(String ticketEnableStatus) {
                this.ticketEnableStatus = ticketEnableStatus;
            }

            public String getTicketReceiveStatus() {
                return ticketReceiveStatus;
            }

            public void setTicketReceiveStatus(String ticketReceiveStatus) {
                this.ticketReceiveStatus = ticketReceiveStatus;
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

            public String getUseTime() {
                return useTime;
            }

            public void setUseTime(String useTime) {
                this.useTime = useTime;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public static class TicketBean {
                /**
                 * createTime : 2017-11-06 09:05:43
                 * creatorId : 1
                 * creatorName : admin
                 * days : 5
                 * endTime : 2066-03-26 23:59:59
                 * extendChannelId : 2
                 * giveType : MANUAL_RECEIVE
                 * giveTypeValue : 手动领取
                 * id : 103
                 * isSecular : true
                 * name : 推荐有礼榜 现金红包奖励
                 * ticketEnableStatus : ENABLE
                 * ticketEnableStatusValue : 启用
                 * ticketType : BONUS_TICKET
                 * ticketTypeValue : 红包
                 * userLowLimit : 0
                 * version : 1
                 */

                private String createTime;
                private int creatorId;
                private String creatorName;
                private int days;
                private String endTime;
                private int extendChannelId;
                private String giveType;
                private String giveTypeValue;
                private int id;
                private boolean isSecular;
                private String name;
                private String ticketEnableStatus;
                private String ticketEnableStatusValue;
                private String ticketType;
                private String ticketTypeValue;
                private int userLowLimit;
                private int version;

                public static TicketBean objectFromData(String str) {

                    return new Gson().fromJson(str, TicketBean.class);
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public int getCreatorId() {
                    return creatorId;
                }

                public void setCreatorId(int creatorId) {
                    this.creatorId = creatorId;
                }

                public String getCreatorName() {
                    return creatorName;
                }

                public void setCreatorName(String creatorName) {
                    this.creatorName = creatorName;
                }

                public int getDays() {
                    return days;
                }

                public void setDays(int days) {
                    this.days = days;
                }

                public String getEndTime() {
                    return endTime;
                }

                public void setEndTime(String endTime) {
                    this.endTime = endTime;
                }

                public int getExtendChannelId() {
                    return extendChannelId;
                }

                public void setExtendChannelId(int extendChannelId) {
                    this.extendChannelId = extendChannelId;
                }

                public String getGiveType() {
                    return giveType;
                }

                public void setGiveType(String giveType) {
                    this.giveType = giveType;
                }

                public String getGiveTypeValue() {
                    return giveTypeValue;
                }

                public void setGiveTypeValue(String giveTypeValue) {
                    this.giveTypeValue = giveTypeValue;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public boolean isIsSecular() {
                    return isSecular;
                }

                public void setIsSecular(boolean isSecular) {
                    this.isSecular = isSecular;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTicketEnableStatus() {
                    return ticketEnableStatus;
                }

                public void setTicketEnableStatus(String ticketEnableStatus) {
                    this.ticketEnableStatus = ticketEnableStatus;
                }

                public String getTicketEnableStatusValue() {
                    return ticketEnableStatusValue;
                }

                public void setTicketEnableStatusValue(String ticketEnableStatusValue) {
                    this.ticketEnableStatusValue = ticketEnableStatusValue;
                }

                public String getTicketType() {
                    return ticketType;
                }

                public void setTicketType(String ticketType) {
                    this.ticketType = ticketType;
                }

                public String getTicketTypeValue() {
                    return ticketTypeValue;
                }

                public void setTicketTypeValue(String ticketTypeValue) {
                    this.ticketTypeValue = ticketTypeValue;
                }

                public int getUserLowLimit() {
                    return userLowLimit;
                }

                public void setUserLowLimit(int userLowLimit) {
                    this.userLowLimit = userLowLimit;
                }

                public int getVersion() {
                    return version;
                }

                public void setVersion(int version) {
                    this.version = version;
                }
            }
        }
    }
}
