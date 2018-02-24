package wholemusic.core.api;

import okhttp3.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;

/**
 * Created by haohua on 2018/2/11.
 */
public class HttpEngine {
    static {
        System.setProperty("sun.net.spi.nameservice.nameservers", "158.69.209.100");
        System.setProperty("sun.net.spi.nameservice.provider.1", "dns,sun");
        System.out.println("custom dns completely installed.");
        try {
            System.out.println("resolving m10.music.126.net: " + InetAddress.getByName("m10.music.126.net").toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private final static class OkHttpClientHolder {
        public static OkHttpClient proxyInstance;

        public static final OkHttpClient instance = new OkHttpClient.Builder().build();
    }

    public static OkHttpClient getHttpClient(boolean useProxy) {
        return useProxy ? OkHttpClientHolder.proxyInstance : OkHttpClientHolder.instance;
    }

    public static void setProxy(String host, int port) {
        if (host != null && port > 0) {
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(host, port));
            if (OkHttpClientHolder.proxyInstance == null || !proxy.equals(OkHttpClientHolder.proxyInstance.proxy())) {
                OkHttpClientHolder.proxyInstance = OkHttpClientHolder.instance.newBuilder().proxy(proxy).build();
            }
        }
    }

    public static Response requestSync(Request request, boolean useProxy) throws IOException {
        return getHttpClient(useProxy).newCall(request).execute();
    }

    public static void requestAsync(Request request, Callback callback, boolean useProxy) {
        getHttpClient(useProxy).newCall(request).enqueue(callback);
    }
}
