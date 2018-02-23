package wholemusic.core.provider.kuwo;

import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.BaseRequest;
import wholemusic.core.config.Constants;

import java.io.IOException;

/**
 * Created by haohua on 2018/2/23.
 */
@SuppressWarnings("SpellCheckingInspection")
class KuwoGetMusicLinkRequest extends BaseRequest<KuwoSongLink> {
    private final String mMusicRid;

    public KuwoGetMusicLinkRequest(String musicRid) {
        mMusicRid = musicRid;
    }

    @Override
    protected Request buildRequest() {
        Request.Builder requestBuilder = new Request.Builder();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://player.kuwo.cn/webmusic/st/getNewMuiseByRid").newBuilder();
        urlBuilder.addQueryParameter("rid", mMusicRid);
        requestBuilder.url(urlBuilder.build());
        requestBuilder.addHeader(Constants.REFERER, "http://player.kuwo.cn/webmusic/play");
        requestBuilder.get();
        final Request request = requestBuilder.build();
        return request;
    }

    @Override
    protected KuwoSongLink parseResult(Response response) throws IOException {
        JSONObject responseJson = JSONObject.parseObject(response.body().string());
        KuwoSongLink link = responseJson.toJavaObject(KuwoSongLink.class);
        return link;
    }
}
