package xidaiw.mine.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/2/26.
 */

public class SmsInfo {
    /**
     * code : 1
     * data : {"registered":false}
     * message : 手机号注册查询成功
     * success : true
     */
    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static SmsInfo objectFromData(String str) {

        return new Gson().fromJson(str, SmsInfo.class);
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
         * registered : false
         */

        private boolean registered;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public boolean isRegistered() {
            return registered;
        }

        public void setRegistered(boolean registered) {
            this.registered = registered;
        }
    }
}
