package xidaiw.mine.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/3/5.
 */

public class WithdrawInfo {

    /**
     * code : 50006
     * message : 银行卡与账户不匹配
     * success : false
     * data : null
     */

    private int code;
    private String message;
    private boolean success;
    private Object data;

    public static WithdrawInfo objectFromData(String str) {

        return new Gson().fromJson(str, WithdrawInfo.class);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
