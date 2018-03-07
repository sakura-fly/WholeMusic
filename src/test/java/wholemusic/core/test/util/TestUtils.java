package wholemusic.core.test.util;

import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.HttpEngine;

import java.io.IOException;

public class TestUtils {
    public static int testDownload(String url) throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.get();
        Response response = HttpEngine.requestSync(builder.build(), false);
        int code = response.code();
        response.close();
        return code;
    }
}
