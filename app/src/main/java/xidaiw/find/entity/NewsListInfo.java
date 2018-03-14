package xidaiw.find.entity;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by admin on 2018/3/14.
 */

public class NewsListInfo {

    /**
     * code : 1
     * data : {"list":[{"content":"<div><img alt='' src='http://101.37.174.8/ftp_user/news/1520493724102.jpg' style='width: 599px!important； height: 2198pxmargin: 0px auto;display: block;' /><\/div><div>&ldquo;3.8日女神节&rdquo;<\/div><div>妇人的天地，女人的财富，<\/div><div>这个专区，活动奖品丰富，<\/div><div>专属女性理财专区~<\/div><div>&ldquo;加息还送券&rdquo;，排名还有丰富奖品！<\/div><div>等你抢<\/div><div>嘘！<\/div><div>详情请咨询客服热线：4000755190！<\/div><div>&nbsp;<\/div><div>活动规则:<\/div><div>1. 此活动仅限于90天以上标的（限投180天/360天标的）；和任意活动标的组合， 此活动不包括新手标；<\/div><div>2. 现金红包可在【我的红包】内查看，红包七日内领取有效，逾期失效。<\/div><div>3. 活动前三名的礼品在活动结束后7个工作日内寄出。<\/div><div>4. 女人专区只限于女性，专区具有所有人游览，投资只限制女性专投。<\/div><div>&nbsp;<\/div><div>活动时间：3月1日&mdash;3月31日<\/div>","createTime":"2018-03-08 15:17:59","enable":true,"id":248,"name":"\u201c3.8日女神节\u201d来就送 I phoneX 精美礼品分享此文章即可获得100元代金券，速来抢购~","newsType":"HANG_YE_NEW","pulishTime":"2018-03-08 00:00:00","updateTime":"2018-03-08 15:17:59"}],"total":10}
     * message : 查询成功
     * success : true
     */

    private int code;
    private DataBean data;
    private String message;
    private boolean success;

    public static NewsListInfo objectFromData(String str) {

        return new Gson().fromJson(str, NewsListInfo.class);
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
         * list : [{"content":"<div><img alt='' src='http://101.37.174.8/ftp_user/news/1520493724102.jpg' style='width: 599px!important； height: 2198pxmargin: 0px auto;display: block;' /><\/div><div>&ldquo;3.8日女神节&rdquo;<\/div><div>妇人的天地，女人的财富，<\/div><div>这个专区，活动奖品丰富，<\/div><div>专属女性理财专区~<\/div><div>&ldquo;加息还送券&rdquo;，排名还有丰富奖品！<\/div><div>等你抢<\/div><div>嘘！<\/div><div>详情请咨询客服热线：4000755190！<\/div><div>&nbsp;<\/div><div>活动规则:<\/div><div>1. 此活动仅限于90天以上标的（限投180天/360天标的）；和任意活动标的组合， 此活动不包括新手标；<\/div><div>2. 现金红包可在【我的红包】内查看，红包七日内领取有效，逾期失效。<\/div><div>3. 活动前三名的礼品在活动结束后7个工作日内寄出。<\/div><div>4. 女人专区只限于女性，专区具有所有人游览，投资只限制女性专投。<\/div><div>&nbsp;<\/div><div>活动时间：3月1日&mdash;3月31日<\/div>","createTime":"2018-03-08 15:17:59","enable":true,"id":248,"name":"\u201c3.8日女神节\u201d来就送 I phoneX 精美礼品分享此文章即可获得100元代金券，速来抢购~","newsType":"HANG_YE_NEW","pulishTime":"2018-03-08 00:00:00","updateTime":"2018-03-08 15:17:59"}]
         * total : 10
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
             * content : <div><img alt='' src='http://101.37.174.8/ftp_user/news/1520493724102.jpg' style='width: 599px!important； height: 2198pxmargin: 0px auto;display: block;' /></div><div>&ldquo;3.8日女神节&rdquo;</div><div>妇人的天地，女人的财富，</div><div>这个专区，活动奖品丰富，</div><div>专属女性理财专区~</div><div>&ldquo;加息还送券&rdquo;，排名还有丰富奖品！</div><div>等你抢</div><div>嘘！</div><div>详情请咨询客服热线：4000755190！</div><div>&nbsp;</div><div>活动规则:</div><div>1. 此活动仅限于90天以上标的（限投180天/360天标的）；和任意活动标的组合， 此活动不包括新手标；</div><div>2. 现金红包可在【我的红包】内查看，红包七日内领取有效，逾期失效。</div><div>3. 活动前三名的礼品在活动结束后7个工作日内寄出。</div><div>4. 女人专区只限于女性，专区具有所有人游览，投资只限制女性专投。</div><div>&nbsp;</div><div>活动时间：3月1日&mdash;3月31日</div>
             * createTime : 2018-03-08 15:17:59
             * enable : true
             * id : 248
             * name : “3.8日女神节”来就送 I phoneX 精美礼品分享此文章即可获得100元代金券，速来抢购~
             * newsType : HANG_YE_NEW
             * pulishTime : 2018-03-08 00:00:00
             * updateTime : 2018-03-08 15:17:59
             */

            private String content;
            private String createTime;
            private boolean enable;
            private int id;
            private String name;
            private String newsType;
            private String pulishTime;
            private String updateTime;

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

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNewsType() {
                return newsType;
            }

            public void setNewsType(String newsType) {
                this.newsType = newsType;
            }

            public String getPulishTime() {
                return pulishTime;
            }

            public void setPulishTime(String pulishTime) {
                this.pulishTime = pulishTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
