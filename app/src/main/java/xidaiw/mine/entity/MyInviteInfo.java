package xidaiw.mine.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/3/8.
 */

public class MyInviteInfo {

    /**
     * code : 1
     * data : {"total":[{"amount":0,"awardMoney":5,"awardTime":"2017-09-13 10:57:05","id":61,"level":1,"mobile":"13006134970","name":"孙昌镐","recommendCustomerId":53277,"recommendedCustomerId":53999},{"amount":1000,"awardMoney":0.01,"awardTime":"2017-11-07 21:14:56","createTime":"2017-11-07 14:22:54","id":116,"level":1,"mobile":"17771600362","name":"孙昌镐","recommendCustomerId":53277,"recommendedCustomerId":54058},{"amount":0,"awardMoney":0,"awardTime":"2017-11-19 16:25:27","createTime":"2017-11-19 16:25:27","id":158,"level":2,"mobile":"14714946761","name":"孙昌镐","recommendCustomerId":53277,"recommendedCustomerId":54125},{"amount":0,"awardMoney":0,"awardTime":"2017-11-19 23:20:16","createTime":"2017-11-19 23:20:16","id":162,"level":2,"mobile":"17719572172","name":"孙昌镐","recommendCustomerId":53277,"recommendedCustomerId":54129},{"amount":0,"awardMoney":0,"awardTime":"2018-01-25 17:42:00","createTime":"2018-01-25 17:42:00","id":528,"level":1,"mobile":"18040551470","name":"孙昌镐","recommendCustomerId":53277,"recommendedCustomerId":55481}]}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static MyInviteInfo objectFromData(String str) {

        return new Gson().fromJson(str, MyInviteInfo.class);
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
        private List<TotalBean> total;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public List<TotalBean> getTotal() {
            return total;
        }

        public void setTotal(List<TotalBean> total) {
            this.total = total;
        }

        public static class TotalBean {
            /**
             * amount : 0
             * awardMoney : 5
             * awardTime : 2017-09-13 10:57:05
             * id : 61
             * level : 1
             * mobile : 13006134970
             * name : 孙昌镐
             * recommendCustomerId : 53277
             * recommendedCustomerId : 53999
             * createTime : 2017-11-07 14:22:54
             */

            private int amount;
            private double awardMoney;
            private String awardTime;
            private int id;
            private int level;
            private String mobile;
            private String name;
            private int recommendCustomerId;
            private int recommendedCustomerId;
            private String createTime;

            public static TotalBean objectFromData(String str) {

                return new Gson().fromJson(str, TotalBean.class);
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public double getAwardMoney() {
                return awardMoney;
            }

            public void setAwardMoney(double awardMoney) {
                this.awardMoney = awardMoney;
            }

            public String getAwardTime() {
                return awardTime;
            }

            public void setAwardTime(String awardTime) {
                this.awardTime = awardTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getRecommendCustomerId() {
                return recommendCustomerId;
            }

            public void setRecommendCustomerId(int recommendCustomerId) {
                this.recommendCustomerId = recommendCustomerId;
            }

            public int getRecommendedCustomerId() {
                return recommendedCustomerId;
            }

            public void setRecommendedCustomerId(int recommendedCustomerId) {
                this.recommendedCustomerId = recommendedCustomerId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
