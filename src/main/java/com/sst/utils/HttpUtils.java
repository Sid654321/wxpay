package com.sst.utils;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 封装http post get
 */
public class HttpUtils {

    private static final Gson gson = new Gson();
    private static  final  Integer timeout = 5000;

    /**
     * get方法
     * @param url
     * @return
     */
    public static Map<String,Object> doGet(String url){

        Map<String,Object> map = new HashMap<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setSocketTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setRedirectsEnabled(true)//允许重定向
                .build();
        HttpGet httpGet =  new HttpGet(url);
        httpGet.setConfig(requestConfig);

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                String jsonResult = EntityUtils.toString(httpResponse.getEntity());
                map = gson.fromJson(jsonResult,map.getClass());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public static String doPost(String url,String data){
        CloseableHttpClient httpClient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setSocketTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setRedirectsEnabled(true)//允许重定向
                .build();
        HttpPost httpPost = new HttpPost();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-type","text/html; charset=UTF-8");

        if(data != null && data instanceof String){
            StringEntity stringEntity = new StringEntity(data, "UTF-8");
            httpPost.setEntity(stringEntity);
        }

        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                String result = EntityUtils.toString(httpEntity);
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


}
