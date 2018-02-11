package wholemusic.core.api;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
}
