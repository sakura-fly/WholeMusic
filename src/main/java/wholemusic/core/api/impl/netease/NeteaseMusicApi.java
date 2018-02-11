package wholemusic.core.api.impl.netease;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Hex;
import wholemusic.core.api.MusicApi;
import wholemusic.core.api.model.Music;
import wholemusic.core.api.model.MusicLink;
import wholemusic.core.util.AES;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/10.
 */
public class NeteaseMusicApi implements MusicApi {
    private static final String SECRET = "7246674226682325323F5E6544673A51";

    @Override
    public List<? extends Music> searchMusic(String keyword) throws IOException {
        List<NeteaseSong> result = new NeteaseSearchMusicRequest(keyword, 0).requestSync();
        return result;
    }

    @Override
    public Music getMusicInfoById(String musicId) throws IOException {
        return null;
    }

    @Override
    public MusicLink getMusicLinkById(String musicId) throws IOException {
        final List<? extends MusicLink> result = getMusicLinkByIds(musicId);
        return result.get(0);
    }

    @Override
    public List<? extends MusicLink> getMusicLinkByIds(String... musicIds) throws IOException {
        List<NeteaseSongLink> result = new NeteaseGetMusicLinksRequest(musicIds).requestSync();
        return result;
    }

    static String encrypt(JSONObject json) {
        byte[] encrypted = null;
        try {
            encrypted = AES.encrypt(json.toString(), Hex.decodeHex(SECRET.toCharArray()));
            return Hex.encodeHexString(encrypted).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
