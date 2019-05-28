package com.muhuan.Service.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CurrentAQIByCity {

//    private static String sign = "a45dddee50136e5d9179e1ee753617a5";
//    private static String APPKEY = "40817";
    private static String APPKEY = "5j1znBVAsnSf5xQyNQyq";

    public static String CurrentAQIByCityNumber(String cityName) throws Exception{
        System.out.println(cityName);
        URL u=new URL("http://www.pm25.in/api/querys/pm2_5.json?city="+cityName+"&token="+APPKEY+"&stations=no");
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        System.out.println(new String(b,"utf-8"));
        return new String(b,"utf-8");
    }

//    public static String CurrentAQIByCityNumber(String weaid) throws Exception{
//        URL u=new URL("http://api.k780.com/?app=weather.pm25&weaid="+weaid+"&appkey="+APPKEY+"&sign="+sign+"&format=json");
//        InputStream in=u.openStream();
//        ByteArrayOutputStream out=new ByteArrayOutputStream();
//        try {
//            byte buf[]=new byte[1024];
//            int read = 0;
//            while ((read = in.read(buf)) > 0) {
//                out.write(buf, 0, read);
//            }
//        }  finally {
//            if (in != null) {
//                in.close();
//            }
//        }
//        byte b[]=out.toByteArray( );
////        System.out.println(new String(b,"utf-8"));
//        return new String(b,"utf-8");
//    }


    public static Map<String,Object> CurrentAQIByCity() throws Exception{
        String url = "http://www.pm25.in/rank";
        Map<String ,Object> cityDataMap = new HashMap<>();

        Document doc = Jsoup.connect(url).get();

        Elements trTags = doc.select("body > div.container > div > div.table > table > tbody > tr");
        Elements tdTags = null;
        for (Element trTag : trTags){
            Map<String ,Object> dataMap = new HashMap<>();
            Map<String ,Object> resultMap = new HashMap<>();
            dataMap.put("success",true);
            tdTags = trTag.select("td");
            System.out.println(tdTags.get(1).text());
            resultMap.put("citynm",tdTags.get(1).text());
            resultMap.put("aqi",tdTags.get(2).text());
            resultMap.put("aqi_levid",tdTags.get(3).text());
            resultMap.put("pm2_5",tdTags.get(4).text());
            resultMap.put("pm10",tdTags.get(5).text());
            resultMap.put("co",tdTags.get(6).text());
            resultMap.put("no2",tdTags.get(7).text());
            resultMap.put("o3",tdTags.get(8).text());
            resultMap.put("o3_8h",tdTags.get(9).text());
            resultMap.put("so2",tdTags.get(10).text());
            dataMap.put("result",resultMap);
            cityDataMap.put(tdTags.get(1).text(),dataMap);
        }
        System.out.println(cityDataMap);
        return cityDataMap;


    }


}
