package xidaiw.util;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;

/**
 * Created by admin on 2018/2/26.
 * 用来解析渠道号
 */

public class Channel {
    private static final String TAG="Channel";
    private static String channelID;
    public static String parse(InputStream is){
        Log.i(TAG, "parser方法被调用了吗");
//        XmlPullParser parser = Xml.newPullParser();

        try {

            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            parser.setInput(is,"UTF-8");
            int eventType = parser.getEventType();
            while (eventType!=XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("channel".equals(parser.getName())) {
                            String name = parser.getAttributeValue(0);
                            Log.i(TAG, "parse: channelID被解析了吗?********"+channelID);
                            if("channelID".equals(name)) {
                                channelID = parser.nextText();
                                Log.i(TAG, "parse: channelID被解析了吗?====="+channelID);
                                return channelID;
                            }
                        }
                        break;
                }
                eventType=parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i(TAG, "parse: channelID被解析了吗?+++++++++"+channelID);
        return channelID;
    }
}
