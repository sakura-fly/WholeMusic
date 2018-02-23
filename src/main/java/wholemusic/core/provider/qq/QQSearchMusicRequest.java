package wholemusic.core.provider.qq;

import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.BaseRequest;
import wholemusic.core.model.Song;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
class QQSearchMusicRequest extends BaseRequest<List<? extends Song>> {
    private final String mKeyword;

    public QQSearchMusicRequest(String keyword) {
        mKeyword = keyword;
    }

    @Override
    protected Request buildRequest() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://c.y.qq.com/soso/fcgi-bin/search_for_qq_cp").newBuilder();
        urlBuilder.addQueryParameter("w", mKeyword);
        urlBuilder.addQueryParameter("p", "0");
        urlBuilder.addQueryParameter("n", "20");
        urlBuilder.addQueryParameter("format", "json");
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(urlBuilder.build());
        requestBuilder.addHeader("User-Agent", QQMusicApi.USER_AGENT);
        requestBuilder.addHeader("Referrer", "http://m.y.qq.com");
        requestBuilder.get();
        final Request request = requestBuilder.build();
        return request;
    }

    @Override
    protected List<QQSong> parseResult(Response response) throws IOException {
        JSONObject json = JSONObject.parseObject(response.body().string());
        List<QQSong> list = json.getJSONObject("data").getJSONObject("song").getJSONArray("list")
                .toJavaList(QQSong.class);
        return list;
    }
}
