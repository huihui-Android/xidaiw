package xidaiw.index.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2018/3/22.
 */

public class ProductAgreementInfo {

    /**
     * code : 1
     * data : {"agreementTemplate":{"agreemenId":1,"agreementContent":"我是String html","id":8625,"productId":738}}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static ProductAgreementInfo objectFromData(String str) {

        return new Gson().fromJson(str, ProductAgreementInfo.class);
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
         * agreementTemplate : {"agreemenId":1,"agreementContent":"我是String html","id":8625,"productId":738}
         */

        private AgreementTemplateBean agreementTemplate;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public AgreementTemplateBean getAgreementTemplate() {
            return agreementTemplate;
        }

        public void setAgreementTemplate(AgreementTemplateBean agreementTemplate) {
            this.agreementTemplate = agreementTemplate;
        }

        public static class AgreementTemplateBean {
            /**
             * agreemenId : 1
             * agreementContent : 我是String html
             * id : 8625
             * productId : 738
             */

            private int agreemenId;
            private String agreementContent;
            private int id;
            private int productId;

            public static AgreementTemplateBean objectFromData(String str) {

                return new Gson().fromJson(str, AgreementTemplateBean.class);
            }

            public int getAgreemenId() {
                return agreemenId;
            }

            public void setAgreemenId(int agreemenId) {
                this.agreemenId = agreemenId;
            }

            public String getAgreementContent() {
                return agreementContent;
            }

            public void setAgreementContent(String agreementContent) {
                this.agreementContent = agreementContent;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }
        }
    }
}
