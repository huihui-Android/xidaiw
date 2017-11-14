package btj.util;

/**
 * Created by admin on 2017/11/10.
 */


    public interface OnResponseListener {
        void onSuccess();

        void onCancel();

        void onFail(String message);
    }

