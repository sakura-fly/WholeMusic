package wholemusic.core.provider.xiami;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.BaseRequest;
import wholemusic.core.model.MusicLink;
import wholemusic.core.provider.baidu.BaiduSongLink;
import wholemusic.core.util.TextUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by haohua on 2018/2/23.
 */
@SuppressWarnings("SpellCheckingInspection")
class XiamiGetMusicLinksRequest extends BaseRequest<List<? extends MusicLink>> {
    private final String[] mMusicIds;

    public XiamiGetMusicLinksRequest(String... musicIds) {
        mMusicIds = musicIds;
    }

    @Override
    protected Request buildRequest() {
        Request.Builder requestBuilder = new Request.Builder();
        String songIds = TextUtils.join(",", Arrays.asList(mMusicIds));
        requestBuilder.url(HttpUrl.parse("http://music.baidu.com/data/music/links").newBuilder()
                .addQueryParameter("songIds", songIds).build());
        requestBuilder.addHeader("Referrer", "music.baidu.com/song/" + songIds);
        requestBuilder.get();
        final Request request = requestBuilder.build();
        return request;
    }

    @Override
    protected List<XiamiSongLink> parseResult(Response response) throws IOException {
        JSONObject responseJson = JSONObject.parseObject(response.body().string());
        JSONArray jsonData = responseJson.getJSONObject("data").getJSONArray("songList");
        List<XiamiSongLink> songLinks = jsonData.toJavaList(XiamiSongLink.class);
        return songLinks;
    }
}