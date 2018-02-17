package wholemusic.core.api;

import okhttp3.*;
import wholemusic.core.util.CommonUtils;

import java.io.IOException;

/**
 * Created by haohua on 2018/2/11.
 */
public class HttpEngine {
    private final static class OkHttpClientHolder {
        public static final OkHttpClient instance = new OkHttpClient();
    }

    public static OkHttpClient getHttpClient() {
        return OkHttpClientHolder.instance;
    }

    public static Response requestSync(Request request) throws IOException {
        return getHttpClient().newCall(request).execute();
    }

    public static void requestAsync(Request request, Callback callback) {
        getHttpClient().newCall(request).enqueue(callback);
    }

    public static Response sendHeadRequest(String url) throws IOException {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(HttpUrl.parse(url));
        requestBuilder.head();
        Response response = HttpEngine.requestSync(requestBuilder.build());
        return response;
    }
}
