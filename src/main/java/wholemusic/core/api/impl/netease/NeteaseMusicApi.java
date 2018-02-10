package wholemusic.core.api.impl.netease;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.commons.codec.binary.Hex;
import wholemusic.core.api.framework.MusicApi;
import wholemusic.core.api.framework.model.Music;
import wholemusic.core.api.framework.model.MusicLink;
import wholemusic.core.util.AES;

import java.util.List;

/**
 * Created by haohua on 2018/2/10.
 */
public class NeteaseMusicApi implements MusicApi {
    private static final String SECRET = "7246674226682325323F5E6544673A51";

    private static final int PAGE_SIZE = 10;

    @Override
    public List<? extends Music> searchMusic(String keyword) throws Exception {
        int page = 0;
        OkHttpClient client = new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(HttpUrl.parse("http://music.163.com/api/linux/forward"));
        requestBuilder.addHeader("Referrer", "http://music.163.com/");
        JSONObject json = new JSONObject();
        json.put("method", "POST");
        json.put("url", "http://music.163.com/api/cloudsearch/pc");
        JSONObject params = new JSONObject();
        params.put("s", keyword);
        params.put("type", 1);
        params.put("offset", page * PAGE_SIZE);
        params.put("limit", PAGE_SIZE);
        json.put("params", params);
        String encrypted = encrypt(json);
        FormBody body = new FormBody.Builder().add("eparams", encrypted).build();
        requestBuilder.post(body);
        final Request request = requestBuilder.build();
        Response response = client.newCall(request).execute();
        JSONObject responseJson = JSONObject.parseObject(response.body().string());
        JSONObject result = responseJson.getJSONObject("result");
        long songCount = result.getLongValue("songCount");
        List<NeteaseSong> songs = result.getJSONArray("songs").toJavaList(NeteaseSong.class);
        return songs;
    }

    @Override
    public Music getMusicInfoById(String musicId) throws Exception {
        return null;
    }

    @Override
    public MusicLink getMusicLinkById(String musicId) throws Exception {
        final List<? extends MusicLink> result = getMusicLinkByIds(musicId);
        return result.get(0);
    }

    @Override
    public List<? extends MusicLink> getMusicLinkByIds(String... musicIds) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(HttpUrl.parse("http://music.163.com/api/linux/forward"));
        requestBuilder.addHeader("Referrer", "http://music.163.com/");
        JSONObject json = new JSONObject();
        json.put("method", "POST");
        json.put("url", "http://music.163.com/api/song/enhance/player/url");
        JSONObject params = new JSONObject();
        JSONArray musicIdArray = new JSONArray();
        for (String musicId : musicIds) {
            musicIdArray.add(Long.parseLong(musicId));
        }
        params.put("br", 320000);
        params.put("ids", musicIds);
        json.put("params", params);
        String encrypted = encrypt(json);
        FormBody body = new FormBody.Builder().add("eparams", encrypted).build();
        requestBuilder.post(body);
        final Request request = requestBuilder.build();
        Response response = client.newCall(request).execute();
        JSONObject responseJson = JSONObject.parseObject(response.body().string());
        JSONArray jsonData = responseJson.getJSONArray("data");
        List<NeteaseSongLink> songLinks = jsonData.toJavaList(NeteaseSongLink.class);
        return songLinks;
    }

    private static String encrypt(JSONObject json) throws Exception {
        byte[] encrypted = AES.encrypt(json.toString(), Hex.decodeHex(SECRET.toCharArray()));
        return Hex.encodeHexString(encrypted).toUpperCase();
    }
}
