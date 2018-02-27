package xidaiw.mine.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/2/27.
 */

public class LoginBySmsInfo {

    /**
     * code : 1
     * message : 验证成功
     * success : true
     * data : {"password":"e10adc3949ba59abbe56e057f20f883e","mobile":"18040551470"}
     */

    private int code;
    private String message;
    private boolean success;
    private DataBean data;

    public static LoginBySmsInfo objectFromData(String str) {

        return new Gson().fromJson(str, LoginBySmsInfo.class);
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
         * password : e10adc3949ba59abbe56e057f20f883e
         * mobile : 18040551470
         */

        private String password;
        private String mobile;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
