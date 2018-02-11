package wholemusic.core.api.impl.netease;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.BaseRequest;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
public class NeteaseGetMusicLinksRequest extends BaseRequest<List<NeteaseSongLink>> {
    private final String[] mMusicIds;

    public NeteaseGetMusicLinksRequest(String... musicIds) {
        mMusicIds = musicIds;
    }

    @Override
    protected Request buildRequest() {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(HttpUrl.parse("http://music.163.com/api/linux/forward"));
        requestBuilder.addHeader("Referrer", "http://music.163.com/");
        JSONObject json = new JSONObject();
        json.put("method", "POST");
        json.put("url", "http://music.163.com/api/song/enhance/player/url");
        JSONObject params = new JSONObject();
        JSONArray musicIdArray = new JSONArray();
        for (String musicId : mMusicIds) {
            musicIdArray.add(Long.parseLong(musicId));
        }
        params.put("br", 320000);
        params.put("ids", musicIdArray);
        json.put("params", params);
        String encrypted = NeteaseMusicApi.encrypt(json);
        FormBody body = new FormBody.Builder().add("eparams", encrypted).build();
        requestBuilder.post(body);
        final Request request = requestBuilder.build();
        return request;
    }

    @Override
    protected List<NeteaseSongLink> parseResult(Response response) throws IOException {
        JSONObject responseJson = JSONObject.parseObject(response.body().string());
        JSONArray jsonData = responseJson.getJSONArray("data");
        List<NeteaseSongLink> songLinks = jsonData.toJavaList(NeteaseSongLink.class);
        return songLinks;
    }
}
