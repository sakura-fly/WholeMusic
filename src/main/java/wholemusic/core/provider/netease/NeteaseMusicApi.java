package wholemusic.core.provider.netease;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Hex;
import wholemusic.core.api.MusicApi;
import wholemusic.core.api.RequestCallback;
import wholemusic.core.model.Music;
import wholemusic.core.model.MusicLink;
import wholemusic.core.util.AES;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/10.
 */
public class NeteaseMusicApi implements MusicApi {
    private static final String SECRET = "7246674226682325323F5E6544673A51";

    @Override
    public void searchMusicAsync(String keyword, int page, RequestCallback<List<? extends Music>> callback) {
        new NeteaseSearchMusicRequest(keyword, page).requestAsync(callback);
    }

    @Override
    public void getMusicInfoByIdAsync(String musicId, RequestCallback<? extends Music> callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getMusicLinkByIdAsync(String musicId, final RequestCallback<MusicLink> callback) {
        getMusicLinkByIdsAsync(new RequestCallback<List<? extends MusicLink>>() {
            @Override
            public void onFailure(IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onSuccess(List<? extends MusicLink> musicLinks) {
                MusicLink link = musicLinks.get(0);
                callback.onSuccess(link);
            }
        }, musicId);
    }

    @Override
    public void getMusicLinkByIdsAsync(RequestCallback<List<? extends MusicLink>> callback, String... musicIds) {
        new NeteaseGetMusicLinksRequest(musicIds).requestAsync(callback);
    }

    static String encrypt(JSONObject json) {
        byte[] encrypted;
        try {
            encrypted = AES.encrypt(json.toString(), Hex.decodeHex(SECRET.toCharArray()));
            return Hex.encodeHexString(encrypted).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
