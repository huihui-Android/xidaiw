package xidaiw.index.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/2/28.
 */

public class MessageList2 {

    /**
     * code : 1
     * data : {"list":[{"content":"恭喜您获得688元、300元、200元、100元代金券，现在加入新手标可享16年化，闲钱闲置不如投资增值，快快前往往\u201c我的账户-我的奖励\u201d查看吧！","createTime":"2018-02-26 11:11:51","customerId":55521,"id":3311,"isRead":0,"title":"注册奖励"}],"total":1}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static MessageList2 objectFromData(String str) {

        return new Gson().fromJson(str, MessageList2.class);
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
         * list : [{"content":"恭喜您获得688元、300元、200元、100元代金券，现在加入新手标可享16年化，闲钱闲置不如投资增值，快快前往往\u201c我的账户-我的奖励\u201d查看吧！","createTime":"2018-02-26 11:11:51","customerId":55521,"id":3311,"isRead":0,"title":"注册奖励"}]
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
             * content : 恭喜您获得688元、300元、200元、100元代金券，现在加入新手标可享16年化，闲钱闲置不如投资增值，快快前往往“我的账户-我的奖励”查看吧！
             * createTime : 2018-02-26 11:11:51
             * customerId : 55521
             * id : 3311
             * isRead : 0
             * title : 注册奖励
             */

            private String content;
            private String createTime;
            private int customerId;
            private int id;
            private int isRead;
            private String title;

            public static ListBean objectFromData(String str) {

                return new Gson().fromJson(str, ListBean.class);
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsRead() {
                return isRead;
            }

            public void setIsRead(int isRead) {
                this.isRead = isRead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
