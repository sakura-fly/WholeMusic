package wholemusic.core.provider.baidu;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.BaseRequest;
import wholemusic.core.model.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohua on 2018/2/23.
 */
@SuppressWarnings("SpellCheckingInspection")
public class BaiduSearchMusicRequest extends BaseRequest<List<? extends Song>> {
    private final String mKeyword;
    private static final int PAGE_SIZE = 20;
    private final int mPage;

    public BaiduSearchMusicRequest(String keyword, int page) {
        mKeyword = keyword;
        mPage = page;
    }

    @Override
    protected Request buildRequest() {
        Request.Builder requestBuilder = new Request.Builder();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://musicapi.qianqian.com/v1/restserver/ting").newBuilder();
        urlBuilder.addQueryParameter("method", "baidu.ting.search.common");
        urlBuilder.addQueryParameter("query", mKeyword);
        urlBuilder.addQueryParameter("format", "json");
        urlBuilder.addQueryParameter("page_no", String.valueOf(mPage));
        urlBuilder.addQueryParameter("page_size", String.valueOf(PAGE_SIZE));
        requestBuilder.url(urlBuilder.build());
        requestBuilder.addHeader("Referrer", "http://music.baidu.com/");
        requestBuilder.get();
        final Request request = requestBuilder.build();
        return request;
    }

    @Override
    protected List<BaiduSong> parseResult(Response response) throws IOException {
        JSONObject responseJson = JSONObject.parseObject(response.body().string());
        JSONArray songArray = responseJson.getJSONArray("song_list");
        List<BaiduSong> songs = new ArrayList<>();
        if (songArray != null) {
            songs = songArray.toJavaList(BaiduSong.class);
        }
        return songs;
    }
}
