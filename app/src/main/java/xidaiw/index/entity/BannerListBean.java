package xidaiw.index.entity;

import com.google.gson.Gson;

/**
 * Created by admin on 2017/11/7.
 */

public class BannerListBean {

    /**
     * channelId : 0
     * createTime : 2017-08-25 11:24:35
     * enable : true
     * htmlTitle : 喜袋榜
     * htmlURL : http://activity.xidaiw.com/event/xidaiw/wap/index/1
     * id : 56
     * imageURI : http://101.37.174.8/ftp_user/banner/xidaibang.png
     * name : 喜袋网
     * osType : OS_IOS_ANDROID
     */

    private int channelId;
    private String createTime;
    private boolean enable;
    private String htmlTitle;
    private String htmlURL;
    private int id;
    private String imageURI;
    private String name;
    private String osType;

    public static BannerListBean objectFromData(String str) {

        return new Gson().fromJson(str, BannerListBean.class);
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
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

    public String getHtmlTitle() {
        return htmlTitle;
    }

    public void setHtmlTitle(String htmlTitle) {
        this.htmlTitle = htmlTitle;
    }

    public String getHtmlURL() {
        return htmlURL;
    }

    public void setHtmlURL(String htmlURL) {
        this.htmlURL = htmlURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    @Override
    public String toString() {
        return "BannerListBean{" +
                "channelId=" + channelId +
                ", createTime='" + createTime + '\'' +
                ", enable=" + enable +
                ", htmlTitle='" + htmlTitle + '\'' +
                ", htmlURL='" + htmlURL + '\'' +
                ", id=" + id +
                ", imageURI='" + imageURI + '\'' +
                ", name='" + name + '\'' +
                ", osType='" + osType + '\'' +
                '}';
    }
}
