package xidaiw.index.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/2/28.
 */

public class MessageList1 {

    /**
     * code : 1
     * data : {"list":[{"createTime":"2018-02-09 15:23:16","enable":true,"id":34,"messageContent":"恢复时间另行通知，请您合理安排业务，给您带来的不便敬请谅解，如有疑问可详询400-0755-190。","messageTitle":"重要支付通知","updateTime":"2018-02-09 15:23:16"},{"createTime":"2017-12-29 14:33:18","enable":true,"id":25,"messageContent":"尊敬的喜袋网用户们：您好!","messageTitle":"关于元旦假期及奖励发放通知","updateTime":"2017-12-29 14:33:18"}],"total":27}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static MessageList1 objectFromData(String str) {

        return new Gson().fromJson(str, MessageList1.class);
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
         * list : [{"createTime":"2018-02-09 15:23:16","enable":true,"id":34,"messageContent":"恢复时间另行通知，请您合理安排业务，给您带来的不便敬请谅解，如有疑问可详询400-0755-190。","messageTitle":"重要支付通知","updateTime":"2018-02-09 15:23:16"},{"createTime":"2017-12-29 14:33:18","enable":true,"id":25,"messageContent":"尊敬的喜袋网用户们：您好!","messageTitle":"关于元旦假期及奖励发放通知","updateTime":"2017-12-29 14:33:18"}]
         * total : 27
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
             * createTime : 2018-02-09 15:23:16
             * enable : true
             * id : 34
             * messageContent : 恢复时间另行通知，请您合理安排业务，给您带来的不便敬请谅解，如有疑问可详询400-0755-190。
             * messageTitle : 重要支付通知
             * updateTime : 2018-02-09 15:23:16
             */

            private String createTime;
            private boolean enable;
            private int id;
            private String messageContent;
            private String messageTitle;
            private String updateTime;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMessageContent() {
                return messageContent;
            }

            public void setMessageContent(String messageContent) {
                this.messageContent = messageContent;
            }

            public String getMessageTitle() {
                return messageTitle;
            }

            public void setMessageTitle(String messageTitle) {
                this.messageTitle = messageTitle;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
