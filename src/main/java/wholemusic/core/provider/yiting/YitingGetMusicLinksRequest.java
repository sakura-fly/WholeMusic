package wholemusic.core.provider.yiting;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.BaseRequest;
import wholemusic.core.model.MusicLink;
import wholemusic.core.util.TextUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by haohua on 2018/2/23.
 */
@SuppressWarnings("SpellCheckingInspection")
class YitingGetMusicLinksRequest extends BaseRequest<List<? extends MusicLink>> {
    private final String[] mMusicIds;

    public YitingGetMusicLinksRequest(String... musicIds) {
        mMusicIds = musicIds;
    }

    @Override
    protected Request buildRequest() {
        Request.Builder requestBuilder = new Request.Builder();
        String songIds = TextUtils.join(",", Arrays.asList(mMusicIds));
        requestBuilder.url(HttpUrl.parse("http://h5.1ting.com/touch/api/song").newBuilder()
                .addQueryParameter("ids", songIds).build());
        requestBuilder.addHeader("Referrer", "http://h5.1ting.com/#/song" + songIds);
        requestBuilder.get();
        final Request request = requestBuilder.build();
        return request;
    }

    @Override
    protected List<YitingSongLink> parseResult(Response response) throws IOException {
        String body = response.body().string();
        JSONArray jsonData = JSONObject.parseArray(body);
        List<YitingSongLink> songLinks = jsonData.toJavaList(YitingSongLink.class);
        return songLinks;
    }
}
