package com.example.msphone;

import java.io.IOException;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class httphelp {

    private static OkHttpClient httpClient;

    static {
        try {
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)      //设置连接超时
                    .readTimeout(10, TimeUnit.SECONDS)         //设置读超时
                    .writeTimeout(5, TimeUnit.SECONDS)        //设置写超时
                    .retryOnConnectionFailure(true)
                    .build();
            ;


        } catch (Exception e) {

        }
    }


    // POST 方法
    public static CompletableFuture<String> postd(String url, String content) {
        MediaType contentType = MediaType.parse("application/json, text/plain, */*");
        RequestBody body = RequestBody.create(contentType, content);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        return executeRequest(request);
    }

    // GET 方法
    public static CompletableFuture<String> getd(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        return executeRequest(request);
    }

    // 执行请求并返回 CompletableFuture
    private static CompletableFuture<String> executeRequest(Request request) {
        CompletableFuture<String> future = new CompletableFuture<>();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                future.completeExceptionally(e); // 完成异常
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    future.complete(response.body().string()); // 完成并返回结果
                } else {
                    future.completeExceptionally(new IOException("Unexpected code " + response));
                }
            }
        });

        return future;
    }
}