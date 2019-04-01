package com.example.yuroko.appfood.jsoup;

import android.util.Log;

import com.example.yuroko.appfood.entity.Information;
import com.example.yuroko.appfood.view.activity.MainActivity;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataCrawlerOpen {

private static final String TAG = "TAG";
public   String pagetitle;



    public void crawleDataopen(final OnResultCallBack callBack)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Information> informationList =excute1();
                    callBack.onSuccess(informationList,pagetitle);
                } catch (IOException e) {
                    e.printStackTrace();
                    callBack.onFailure(e);
                }

            }
        }).start();
    }

    public List<Information> excute1()  throws IOException
    {

        Log.d(TAG, "excute1: ");
        //String url="https://600tuvungtoeic.com/index.php?mod=lesson&id=1";
        Document document = Jsoup.connect(MainActivity.href).get();

        Element element=document.selectFirst("div.lesson-content");
        pagetitle =element.selectFirst("h2").text();

        Elements items =document.select("div.tuvung");

        List<Information> informations =new ArrayList<>();

        for (Element item:items) {
            try {


                String stt = item.select("div.stt").text();
                Elements images = item.select("img");
                String avatar = images.get(0).attr("src");
                Elements gtt = item.select("div.noidung");
                String noidung = item.select("span").get(0).text();
                String cachdoc = item.select("span").get(1).text();
                Elements contents = item.select("div.noidung");

                Element dong1 = contents.select("span").get(2);
                Node node1 = dong1.nextSibling();
                String giaithich = node1.toString();


                Element dong2 = contents.select("span").get(3);
                Node node2 = dong2.nextSibling();
                String tuloai = node2.toString();

                Element dong3 = contents.select("span").get(4);
                Node node3 = dong3.nextSibling();
                String vidu = node3.toString();

                String vietsub = item.selectFirst("b").text();
                Elements amthanh = contents.select("source");

                String origin = "https://600tuvungtoeic.com/";
                String mp3 = origin+ amthanh.get(0).attr("src");

                informations.add(new Information(pagetitle, stt, avatar, noidung, cachdoc, giaithich, tuloai, vidu, vietsub,mp3));
                Log.d("AAA", mp3.toString());
            }
            catch (Exception e){}

        }
        return informations;
    }
    public interface OnResultCallBack{
        void onSuccess(List<Information> informationList,String pagetitle);
        void onFailure(Throwable throwable);
    }
}
