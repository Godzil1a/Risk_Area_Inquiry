package com.my.Utils;

import com.google.gson.Gson;
import com.my.Pojo.Pos;
import com.my.Pojo.Root;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Tool {

    public Root trial(){

        String urlParam = "https://diqu.gezhong.vip/api.php";
        HttpURLConnection con = null;

        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;

        try {
            URL url = new URL(urlParam);
            //得到连接对象
            con = (HttpURLConnection) url.openConnection();
            //设置请求类型
            con.setRequestMethod("GET");
            //设置请求需要返回的数据类型和字符集类型
            con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //允许写出
            con.setDoOutput(true);
            //允许读入
            con.setDoInput(true);
            //不使用缓存
            con.setUseCaches(false);
            //得到响应码
            int responseCode = con.getResponseCode();
            System.out.println(responseCode);

            if(responseCode == HttpURLConnection.HTTP_OK){
                //得到响应流
                InputStream inputStream = con.getInputStream();
                //将响应流转换成字符串
                resultBuffer = new StringBuffer();
                String line;
                buffer = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while ((line = buffer.readLine()) != null) {
                    resultBuffer.append(line);
                }
                System.out.println(resultBuffer.toString());
            }

        }catch(Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Root root = gson.fromJson(resultBuffer.toString(), Root.class);
        return root;
    }

    public List<String> toList(Root root){
        List<String> ans = new ArrayList<>();
        for (Pos pos : root.getData().getHighlist()) {
            String areaName = pos.getArea_name();
            for (String community : pos.getCommunitys()) {
                ans.add(areaName+community);
            }
        }
        for (Pos pos : root.getData().getMiddlelist()) {
            String areaName = pos.getArea_name();
            for (String community : pos.getCommunitys()) {
                ans.add(areaName+community);
            }
        }
        return ans;
    }

}
