package com.example.boardporject.network;

import android.os.Build;

import androidx.annotation.NonNull;

import com.example.boardporject.BuildConfig;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRequest {

    private final static int TIMEOUT_SECONDS = 30;
    //private static final String BASE_URL = "http://183.109.112.57:11729/";
//    private static final String BASE_URL = "http://localhost:8080/";
    private static final String BASE_URL = "http://192.168.0.16:8080/";

    protected Retrofit retrofit;

    public BaseRequest() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(createClient())
                .build();
    }

    private OkHttpClient createClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        client.connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        client.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();

            Map<String, String> header = createHeaders();
            addHeader(header, requestBuilder);
            return chain.proceed(requestBuilder.build());
        });

        if (isInterceptor()) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.addInterceptor(interceptor);
        }
        return client.build();
    }

    private Map<String, String> createHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("deviceType", "AOS");
        headers.put("os", "SDK " + Build.VERSION.SDK_INT);
        return headers;
    }

    private void addHeader(@NonNull Map<String, String> headers, @NonNull Request.Builder requestBuilder) {
        for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
            requestBuilder.addHeader(headerEntry.getKey(), headerEntry.getValue());
        }
    }

    protected boolean isInterceptor() {
        return BuildConfig.DEBUG;
    }
}









