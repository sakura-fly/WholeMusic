package wholemusic.core.provider.xiami;

import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.BaseRequest;
import wholemusic.core.model.Album;
import wholemusic.core.provider.xiami.XiamiAlbum;
import wholemusic.core.provider.xiami.XiamiSong;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */

/**
 * 参考: https://juejin.im/post/5a35228e51882506a463b172
 */
class XiamiGetAlbumInfoRequest extends BaseRequest<Album> {
    private final String mAlbumId;

    public XiamiGetAlbumInfoRequest(String albumId) {
        mAlbumId = albumId;
    }

    @Override
    protected Request buildRequest() {
        Request.Builder requestBuilder = new Request.Builder();
        HttpUrl.Builder builder = HttpUrl.parse("https://c.y.qq.com/v8/fcg-bin/fcg_v8_album_info_cp" +
                ".fcg?g_tk=1278911659&hostUin=0&format=json&inCharset" +
                "=utf8&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0").newBuilder();
        builder.addQueryParameter("albummid", mAlbumId);
        requestBuilder.url(builder.build());
        requestBuilder.get();
        final Request request = requestBuilder.build();
        return request;
    }

    @Override
    protected Album parseResult(Response response) throws IOException {
        JSONObject json = JSONObject.parseObject(response.body().string());
        JSONObject data = json.getJSONObject("data");
        XiamiAlbum album = data.toJavaObject(XiamiAlbum.class);
        List<XiamiSong> songs = data.getJSONArray("list").toJavaList(XiamiSong.class);
        album.setSongs(songs);
        return album;
    }
}
