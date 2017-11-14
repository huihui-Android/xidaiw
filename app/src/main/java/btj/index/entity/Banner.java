package btj.index.entity;

/**
 * Created by admin on 2017/11/6.
 *       channelId	0
         createTime	2017-10-30 14:31:11
         enable	true
         htmlTitle	推荐有礼榜
         htmlURL	http://activity.xidaiw.com/event/recommendWap
         id	68
         imageURI	http://101.37.174.8/ftp_user/banner/20171030.png
         name	推荐有礼榜
         osType	OS_IOS_ANDROID
         sortParameter	236
         updateTime	2017-10-30 14:31:59
 */
public class Banner {
    private int channelId;
    private String createTime;
    private boolean enable;
    private String htmlTitle;
    private String htmlURL;
    private int id;
    private String imageURI;
    private String name;
    private String osType;
    private int sortParameter;
    private String updateTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
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

    public int getSortParameter() {
        return sortParameter;
    }

    public void setSortParameter(int sortParameter) {
        this.sortParameter = sortParameter;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "channelId=" + channelId +
                ", createTime='" + createTime + '\'' +
                ", enable=" + enable +
                ", htmlTitle='" + htmlTitle + '\'' +
                ", htmlURL='" + htmlURL + '\'' +
                ", id=" + id +
                ", imageURI='" + imageURI + '\'' +
                ", name='" + name + '\'' +
                ", osType='" + osType + '\'' +
                ", sortParameter=" + sortParameter +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
