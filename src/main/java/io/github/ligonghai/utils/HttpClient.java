package io.github.ligonghai.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.internal.tls.OkHostnameVerifier;

import javax.annotation.Nonnull;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ligonghai
 */
@Slf4j
public class HttpClient {

    private static OkHttpClient client;

    private static final Map<String, List<Cookie>> STORE = new ConcurrentHashMap<>();

    static {
        try {
            //忽略https证书校验
            X509TrustManager trustManager = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String str) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String str) {
                }
            };
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
            //初始化okhttp
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .followRedirects(true)
                    .followSslRedirects(true)
                    .retryOnConnectionFailure(false)
                    .hostnameVerifier(OkHostnameVerifier.INSTANCE)
                    .sslSocketFactory(sslContext.getSocketFactory(), trustManager)
                    .readTimeout(Duration.ofSeconds(60))
                    .writeTimeout(Duration.ofSeconds(60))
                    .connectTimeout(Duration.ofSeconds(60))
                    .cookieJar(new CookieJar() {
                        @Override
                        public void saveFromResponse(@Nonnull HttpUrl url, @Nonnull List<Cookie> list) {
                            STORE.put(url.host(), list);
                        }

                        @Nonnull
                        @Override
                        public List<Cookie> loadForRequest(@Nonnull HttpUrl url) {
                            return STORE.containsKey(url.host()) ? STORE.get(url.host()) : new ArrayList<Cookie>();
                        }
                    });
            client = builder.build();
        } catch (Exception e) {
            log.error("Okhttp client initialization error", e);
        }
    }

    /**
     * get请求
     *
     * @param url     url
     * @param params  params
     * @param headers headers
     * @return response
     * @throws IOException IOException
     */
    public static String get(@Nonnull String url, @Nonnull Object params, @Nonnull Map<String, String> headers) throws IOException {
        //处理url参数
        HttpUrl httpUrl = check(url);
        HttpUrl.Builder builder = httpUrl.newBuilder();
        Map<String, Object> map = JsonUtil.readValue(JsonUtil.writeValueAsBytes(params), new TypeReference<Map<String, Object>>() {
        });
        for (Map.Entry<String, Object> param : map.entrySet()) {
            builder.addQueryParameter(param.getKey(), param.getValue().toString());
        }
        //发送请求
        Request request = new Request.Builder().url(builder.build())
                .headers(Headers.of(headers)).get().build();
        return execute(request);
    }

    /**
     * post请求
     *
     * @param url     url
     * @param params  params
     * @param headers headers
     * @param isForm  v
     * @return response
     * @throws IOException IOException
     */
    public static String post(@Nonnull String url, @Nonnull Object params, @Nonnull Map<String, String> headers, boolean isForm) throws IOException {
        //处理url参数
        HttpUrl httpUrl = check(url);
        //参数
        RequestBody requestBody;
        String paramStr = JsonUtil.writeValueAsString(params);
        if (isForm) {
            FormBody.Builder builder = new FormBody.Builder();
            JsonUtil.readValue(paramStr, new TypeReference<Map<String, String>>() {
            }).forEach(builder::add);
            requestBody = builder.build();
        } else {
            requestBody = RequestBody.create(MediaType.parse("application/json"), paramStr);
        }
        //发送请求
        Request request = new Request.Builder()
                .url(httpUrl).headers(Headers.of(headers))
                .post(requestBody).build();
        return execute(request);
    }

    private static HttpUrl check(String url) {
        //处理url参数
        HttpUrl httpUrl = HttpUrl.parse(url);
        if (Objects.isNull(httpUrl)) {
            throw new IllegalArgumentException(MessageFormat.format("Invalid url:{0}", url));
        }
        return httpUrl;
    }

    private static String execute(Request request) throws IOException {
        Call call = client.newCall(request);
        try (Response resp = call.execute(); ResponseBody body = resp.body()) {
            if (Objects.isNull(body)) {
                return null;
            }
            return new String(body.bytes(), StandardCharsets.UTF_8);
        }
    }
}
