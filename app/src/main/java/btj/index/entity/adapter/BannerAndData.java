package btj.index.entity.adapter;

import java.util.ArrayList;

/**
 * Created by admin on 2017/11/6.
 *
 *   code	1
     data	Object
     message	查询成功
     success	true
 */

public class BannerAndData {
    private int code;
    private ArrayList<BannerAndData2> data;
    private String message;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<BannerAndData2> getData() {
        return data;
    }

    public void setData(ArrayList<BannerAndData2> data) {
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
}
