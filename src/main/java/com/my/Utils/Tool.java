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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int high = 0, middle = 0;
        Map<String,Integer> highCountMap = new HashMap<>();
        Map<String,List<String>> highStrMap = new HashMap<>();
        for (Pos pos : root.getData().getHighlist()) {
            highCountMap.put(pos.getProvince(),highCountMap.getOrDefault(pos.getProvince(),0)+pos.getCommunitys().size());
            high += pos.getCommunitys().size();
            StringBuffer tmp = new StringBuffer();
            tmp.append(pos.getArea_name()+":");
            for (String community : pos.getCommunitys()) {
                tmp.append(community);
                tmp.append("、");
            }
            tmp.deleteCharAt(tmp.length()-1);
            List<String> list = highStrMap.getOrDefault(pos.getProvince(), new ArrayList<>());
            list.add(tmp.toString());
            highStrMap.put(pos.getProvince(),list);
        }
        ans.add("高风险"+high+"个");
        for (String s : highStrMap.keySet()) {
            ans.add(s+highCountMap.get(s)+"个");
            ans.addAll(highStrMap.get(s));
        }
        Map<String,Integer> middleCountMap = new HashMap<>();
        Map<String,List<String>> middleStrMap = new HashMap<>();
        for (Pos pos : root.getData().getMiddlelist()) {
            middleCountMap.put(pos.getProvince(),middleCountMap.getOrDefault(pos.getProvince(),0)+pos.getCommunitys().size());
            middle += pos.getCommunitys().size();
            StringBuffer tmp = new StringBuffer();
            tmp.append(pos.getArea_name()+":");
            for (String community : pos.getCommunitys()) {
                tmp.append(community);
                tmp.append("、");
            }
            tmp.deleteCharAt(tmp.length()-1);
            List<String> list = middleStrMap.getOrDefault(pos.getProvince(), new ArrayList<>());
            list.add(tmp.toString());
            middleStrMap.put(pos.getProvince(),list);
        }
        ans.add("中风险"+middle+"个");
        for (String s : middleStrMap.keySet()) {
            ans.add(s+middleCountMap.get(s)+"个");
            ans.addAll(middleStrMap.get(s));
        }
        return ans;
    }

}
