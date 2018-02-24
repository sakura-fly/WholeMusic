package wholemusic.core.api;

import okhttp3.*;
import wholemusic.core.util.DnsHelper;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
public class HttpEngine {

    private final static class OkHttpClientHolder {
        public static OkHttpClient proxyInstance;

        public static final OkHttpClient instance = new OkHttpClient.Builder().dns(new Dns() {
            @Override
            public List<InetAddress> lookup(String hostname) throws UnknownHostException {
                List<InetAddress> systemResult = systemDns(hostname);
                ArrayList<InetAddress> finalResult = new ArrayList<>();
                for (InetAddress address : systemResult) {
                    System.out.println(address);
                    System.out.println("isLocal? " + address.isAnyLocalAddress());
                    finalResult.add(address);
                }
//                ArrayList<InetAddress> result = new ArrayList<>();
//                try {
//                    String ip = DnsHelper.resolveIp(hostname);
//                    InetAddress address = InetAddress.getByName(ip);
//                    result.add(address);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                return finalResult;
            }
        }).build();

        private static final List<InetAddress> systemDns(String hostname) throws UnknownHostException {
            if (hostname == null) throw new UnknownHostException("hostname == null");
            try {
                return Arrays.asList(InetAddress.getAllByName(hostname));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException =
                        new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
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
