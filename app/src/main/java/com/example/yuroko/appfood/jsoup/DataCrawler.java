package com.example.yuroko.appfood.jsoup;

import android.util.Log;

import com.example.yuroko.appfood.data.DBCategory;
import com.example.yuroko.appfood.entity.English;
import com.example.yuroko.appfood.view.activity.MainActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataCrawler {

    private static final String TAG ="DataCrawler";
    public  void crawleData(final OnResultCallBack callBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    List<English> englishes = excute();
                    callBack.onSuccess(englishes);
                } catch (IOException e) {
                    e.printStackTrace();
                    callBack.onFailure(e);
                }
            }
        }).start();
    }
        public List<English> excute() throws IOException
        {
          //  String baseUrl="https://600tuvungtoeic.com/";
            String url = "https://600tuvungtoeic.com";

            Document document = Jsoup.connect(url).get();
           // Element element =document.selectFirst("div.gallery-item");

            Elements items =document.select("div.gallery-item");

            List<English> englishes =new ArrayList<>();
            for (Element item:items) {
                Elements images =item.select("img");
                String firstavatar = images.get(0).attr("src");
                String title=item.selectFirst("h3").text();
                Elements lk =item.select("a");
                String href =url+"/"+lk.get(0).attr("href");

             //   Log.d(TAG, "excute title: "+title);
             //   Log.d(TAG, "excute: firstAvatar" +firstavatar);
                Log.d(TAG, "excute: href"+href);
                englishes.add(new English(firstavatar,title,href));
                English english = new English(firstavatar,title,href);
                if(english != null)
                {
                    MainActivity.dbCategory.addcategory(english);
                }

            }
            return englishes ;
        }

    public interface OnResultCallBack{
    void onSuccess(List<English> englishes);
    void onFailure(Throwable throwable);
}

}
