package wholemusic.core.provider.xiami;

import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.BaseRequest;
import wholemusic.core.api.HttpEngine;
import wholemusic.core.model.Song;
import wholemusic.core.provider.xiami.XiamiSong;

import java.io.IOException;
import java.util.List;

/**
*Create by huchunyue on 2018/2/24
 */

public class XiamiSearchMusicRequest extends BaseRequest<List<? extends Song>> {
    private final String mKeyword;
    private static final int PAGE_SIZE = 20;
    //private final int mPage;

    public XiamiSearchMusicRequest(String keyword) {
        mKeyword = keyword;
        //mPage = page;
    }

    @Override
    protected Request buildRequest() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.xiami.com/web").newBuilder();
        urlBuilder.addQueryParameter("key", mKeyword);
        urlBuilder.addQueryParameter("v", "2.0");
        urlBuilder.addQueryParameter("app_key", "1");
        urlBuilder.addQueryParameter("r", "search/songs");
        urlBuilder.addQueryParameter("page","0");
        urlBuilder.addQueryParameter("limit", "10");
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(urlBuilder.build());
        requestBuilder.addHeader("User-Agent", XiamiMusicApi.USER_AGENT);
        requestBuilder.addHeader("Referer", "http://m.xiami.com");
        requestBuilder.get();
        final Request request = requestBuilder.build();
        return request;
    }

    protected List<XiamiSong> parseResult(Response response) throws IOException {
        JSONObject json = JSONObject.parseObject(response.body().string());
        List<XiamiSong> list = json.getJSONObject("data").getJSONArray("songs")
                .toJavaList(XiamiSong.class);
        return list;
    }

/*    public static void main(String args[]){
        XiamiSearchMusicRequest request = new XiamiSearchMusicRequest("Sia");
        request.buildRequest();
        Response response = HttpEngine.requestSync(request);
        List<? extends Song> parsed = parseResult(response);

    }*/
}
