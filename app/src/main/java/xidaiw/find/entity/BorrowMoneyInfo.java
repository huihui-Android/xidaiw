package xidaiw.find.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/3/20.
 */

public class BorrowMoneyInfo {

    /**
     * msg : 服务器返回数据格式错误
     * body : "mobile_have_register"
     * statusCode : 200
     * code : 3
     */

    private String msg;
    private String body;
    private int statusCode;
    private int code;

    public static BorrowMoneyInfo objectFromData(String str) {

        return new Gson().fromJson(str, BorrowMoneyInfo.class);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
