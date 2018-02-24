package wholemusic.core.provider.xiami;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.RequestCallback;
import wholemusic.core.model.Album;
import wholemusic.core.model.MusicLink;
import wholemusic.core.model.Song;
import wholemusic.core.provider.qq.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public class XiamiMusicApi implements MusicApi {


    //private QQUpdateVKeyRequest.VKey mKeyCache;

    static final String USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) " +
            "AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1";

    //@Override
    public void searchMusicAsync(String keyword, int page, RequestCallback<List<? extends Song>> callback) {
        new XiamiSearchMusicRequest(keyword).requestAsync(callback);
    }

    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) throws IOException {
        List<? extends Song> result = new XiamiSearchMusicRequest(keyword).requestSync();
        if (needLink) {
            fillSongLinks(result);
        }
        return result;
    }

    private void fillSongLinks(List<? extends Song> result) throws IOException {
        for (Song song : result) {
         //  song.setMusicLink(getMusicLinkByIdSync(song.getSongId()));
        }
    }

/*    private MusicLink getMusicLinkByIdSync(Song song) throws IOException {
        if (mKeyCache == null) {
            QQUpdateVKeyRequest.VKey vKey = new QQUpdateVKeyRequest().requestSync();
            mKeyCache = vKey;
        }
        QQSongLink result = getSongLink(mKeyCache, song);
        return result;
    }*/

    //@Override
    public void getMusicInfoByIdAsync(String musicId, RequestCallback<? extends Song> callback) {
        throw new UnsupportedOperationException();
    }

    //@Override
    public void getMusicLinkByIdAsync(final String musicId, final RequestCallback<MusicLink> callback) {
        throw new UnsupportedOperationException();
    }

    //@Override
    public MusicLink getMusicLinkByIdSync(String musicId) {
        throw new UnsupportedOperationException();
    }

/*    private static QQSongLink getSongLink(QQUpdateVKeyRequest.VKey vKeyObj, Song song)  {
        String host = vKeyObj.sips.get(0);
        String vKey = vKeyObj.key;
        XiamiSong  xiamiSong = (XiamiSong) song;
        QQSongQuality quality = xiamiSong.guessQuality();
        final String link = buildXiamiMusicLink(host, quality,  song.getSongId(), vKey, GUID);
        QQSongLink result = new QQSongLink();
        result.url = link;
        return result;
    }*/

    //@Override
    public void getMusicLinkByIdsAsync(RequestCallback<List<? extends MusicLink>> callback, String... musicIds) {
        throw new UnsupportedOperationException();
    }

    //@Override
    public void getAlbumInfoByIdAsync(RequestCallback<Album> callback, String albumId) {
        throw new UnsupportedOperationException();
    }

    //@Override
    public Album getAlbumInfoByIdSync(String albumId, boolean needLink) throws IOException {
        Album album = new XiamiGetAlbumInfoRequest(albumId).requestSync();
        fillSongLinks(album.getSongs());
        return album;
    }

/*    private static String buildXiamiMusicLink(String host, QQSongQuality quality, String mid, String key, String guid) {
        String link = host + quality.getPrefix() + mid + "." + quality.getSuffix() + "?vkey=" + key + "&guid=" +
                guid + "&fromtag=1";
        return link;
    }*/
}
