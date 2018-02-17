package wholemusic.core.provider.netease;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.codec.binary.Hex;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.RequestCallback;
import wholemusic.core.model.Album;
import wholemusic.core.model.Song;
import wholemusic.core.model.MusicLink;
import wholemusic.core.util.AES;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haohua on 2018/2/10.
 */
@SuppressWarnings("SpellCheckingInspection")
public class NeteaseMusicApi implements MusicApi {
    private static final String SECRET = "7246674226682325323F5E6544673A51";

    @Override
    public void searchMusicAsync(String keyword, int page, RequestCallback<List<? extends Song>> callback) {
        new NeteaseSearchMusicRequest(keyword, page).requestAsync(callback);
    }

    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) throws IOException {
        List<? extends Song> result = new NeteaseSearchMusicRequest(keyword, page).requestSync();
        if (needLink) {
            ArrayList<String> musicIds = new ArrayList<>();
            for (Song song : result) {
                musicIds.add(song.getSongId());
            }
            List<? extends MusicLink> links = new NeteaseGetMusicLinksRequest(musicIds.toArray(new String[]{}))
                    .requestSync();
            HashMap<String, MusicLink> map = new HashMap<>();
            for (MusicLink link : links) {
                map.put(link.getSongId(), link);
            }
            for (Song song : result) {
                song.setMusicLink(map.get(song.getSongId()));
            }
        }
        return result;
    }

    @Override
    public void getMusicInfoByIdAsync(String musicId, RequestCallback<? extends Song> callback) {
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
    public MusicLink getMusicLinkByIdSync(String musicId) throws IOException {
        return new NeteaseGetMusicLinksRequest(musicId).requestSync().get(0);
    }

    @Override
    public void getMusicLinkByIdsAsync(RequestCallback<List<? extends MusicLink>> callback, String... musicIds) {
        new NeteaseGetMusicLinksRequest(musicIds).requestAsync(callback);
    }

    @Override
    public void getAlbumInfoByIdAsync(RequestCallback<Album> callback, String albumId) {
        new NeteaseGetAlbumInfoRequest(albumId).requestAsync(callback);
    }

    @Override
    public Album getAlbumInfoByIdSync(String albumId) throws IOException {
        return new NeteaseGetAlbumInfoRequest(albumId).requestSync();
    }

    static String encrypt(JSONObject json) {
        byte[] encrypted;
        try {
            encrypted = AES.encrypt(json.toString(), Hex.decodeHex(SECRET.toCharArray()));
            return new String(Hex.encodeHex(encrypted)).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
