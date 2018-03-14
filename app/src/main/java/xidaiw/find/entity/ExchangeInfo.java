package xidaiw.find.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/3/13.
 */

public class ExchangeInfo {

    /**
     * code : 30001
     * message : 积分兑换失败
     * success : false
     * data : null
     */

    private int code;
    private String message;
    private boolean success;
    private Object data;

    public static ExchangeInfo objectFromData(String str) {

        return new Gson().fromJson(str, ExchangeInfo.class);
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
