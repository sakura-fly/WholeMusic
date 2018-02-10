package wholemusic.core.api.impl.qq;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.framework.MusicApi;
import wholemusic.core.api.framework.model.Music;
import wholemusic.core.api.framework.model.MusicLink;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public class QQMusicApi implements MusicApi {

    private static final String GUID = "5150825362";

    private String mKeyCache;
    private String mHostCache;
    private static final String USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) " +
            "AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1";

    public enum Quality {
        High("M800"), Medium("M500"), Low("C400");

        private String prefix;

        Quality(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    public List<? extends Music> searchMusic(String keyWord) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://c.y.qq.com/soso/fcgi-bin/search_for_qq_cp").newBuilder();
        urlBuilder.addQueryParameter("w", keyWord);
        urlBuilder.addQueryParameter("p", "0");
        urlBuilder.addQueryParameter("n", "10");
        urlBuilder.addQueryParameter("format", "json");
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(urlBuilder.build());
        requestBuilder.addHeader("User-Agent", USER_AGENT);
        requestBuilder.addHeader("Referrer", "http://m.y.qq.com");
        requestBuilder.get();
        final Request request = requestBuilder.build();
        Response response = client.newCall(request).execute();
        JSONObject json = JSONObject.parseObject(response.body().string());
        List<QQSong> list = json.getJSONObject("data").getJSONObject("song").getJSONArray("list")
                .toJavaList(QQSong.class);
        return list;
    }

    public Music getMusicInfoById(String musicId) throws IOException {
        return null;
    }

    @Override
    public MusicLink getMusicLinkById(String musicId) throws IOException {
        if (mKeyCache == null) {
            OkHttpClient client = new OkHttpClient();
            HttpUrl.Builder urlBuilder = HttpUrl.parse("http://base.music.qq.com/fcgi-bin/fcg_musicexpress.fcg")
                    .newBuilder();
            urlBuilder.addQueryParameter("json", "3");
            urlBuilder.addQueryParameter("guid", GUID);
            urlBuilder.addQueryParameter("format", "json");
            Request.Builder requestBuilder = new Request.Builder();
            requestBuilder.url(urlBuilder.build());
            requestBuilder.addHeader("User-Agent", USER_AGENT);
            requestBuilder.addHeader("Referrer", "http://y.qq.com");
            requestBuilder.get();
            final Request request = requestBuilder.build();
            Response response = client.newCall(request).execute();
            JSONObject json = JSONObject.parseObject(response.body().string());
            JSONArray sip = json.getJSONArray("sip");
            String host = sip.getString(0);
            String key = json.getString("key");
            mKeyCache = key;
            mHostCache = host;
        }
        final String link = buildQQMusicLink(mHostCache, Quality.High, musicId, mKeyCache, GUID);
        QQSongLink result = new QQSongLink();
        result.url = link;
        return result;
    }

    @Override
    public List<? extends MusicLink> getMusicLinkByIds(String... musicIds) throws Exception {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    private static String buildQQMusicLink(String host, Quality quality, String mid, String key, String guid) {
        return host + quality.getPrefix() + mid + ".mp3?vkey=" + key + "&guid=" + guid + "&fromtag=1";
    }
}
