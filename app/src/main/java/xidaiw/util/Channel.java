package xidaiw.util;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;

/**
 * Created by admin on 2018/2/26.
 * 用来解析渠道号
 */

public class Channel {
    private static String channelID;
    public static String parse(InputStream is){
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(is,"UTF-8");
            int eventType = parser.getEventType();
            while (eventType!=XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("channel".equals(parser.getName())) {
                            String name = parser.getAttributeValue(0);
                            if("channelID".equals(name)) {
                                channelID = parser.getAttributeValue(1);
                                return channelID;
                            }
                        }
                        break;
                }
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channelID;
    }
}
