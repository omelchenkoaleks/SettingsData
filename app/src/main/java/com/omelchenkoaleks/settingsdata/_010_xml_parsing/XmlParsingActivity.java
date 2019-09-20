package com.omelchenkoaleks.settingsdata._010_xml_parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;

import com.omelchenkoaleks.settingsdata.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

public class XmlParsingActivity extends AppCompatActivity {
    private static final String TAG = "XmlParsingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_010_xml_parsing);

        String tmp = "";

        try {
            XmlPullParser xpp = prepareXpp();

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xpp.getEventType()) {

                    // начало документа
                    case XmlPullParser.START_DOCUMENT:
                        Log.d(TAG, "START_DOCUMENT");
                        break;

                    // начало тэга
                    case XmlPullParser.START_TAG:
                        Log.d(TAG, "START_TAG: name = " + xpp.getName()
                                + ", depth = " + xpp.getDepth() + ", attrCount"
                                + xpp.getAttributeCount());

                        tmp = "";
                        for (int i = 0; i < xpp.getAttributeCount(); i++) {
                            tmp = tmp + xpp.getAttributeName(i) + "="
                                    + xpp.getAttributeValue(i) + ", ";
                        }
                        if (!TextUtils.isEmpty(tmp)) {
                            Log.d(TAG, "Attributes: " + tmp);
                        }

                        break;

                    // конец тэга
                    case XmlPullParser.END_TAG:
                        Log.d(TAG, "END_TAG: name = " + xpp.getName());
                        break;

                    // содержимое тэга
                    case XmlPullParser.TEXT:
                        Log.d(TAG, "TEXT = " + xpp.getText());
                        break;

                    default:
                        break;
                }

                // следующий элемент
                xpp.next();
            }

            Log.d(TAG, "END_DOCUMENT");

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // в этом методе вытаскиваем данные из папки res/xml - если файл там )
//    XmlPullParser prepareXpp() {
//        return getResources().getXml(R.xml.data);
//    }

    // если xml не файле, а получаем откудат-то (н-р из Интернета) ...
    XmlPullParser prepareXpp() throws XmlPullParserException {
        // получаем фабрику
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        // включаем поддержку namespace
        factory.setNamespaceAware(true);
        // создаем парсер
        XmlPullParser xpp = factory.newPullParser();
        // даем парсеру на вход Reader
        xpp.setInput(new StringReader(
                "<data><phone><company>Samsung></company></phone></data>"));
        return xpp;
    }
}
