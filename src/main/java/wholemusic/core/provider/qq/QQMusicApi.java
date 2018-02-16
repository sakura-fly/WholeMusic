package wholemusic.core.provider.qq;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.RequestCallback;
import wholemusic.core.model.Album;
import wholemusic.core.model.Song;
import wholemusic.core.model.MusicLink;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public class QQMusicApi implements MusicApi {

    static final String GUID = "5150825362";

    private QQUpdateVKeyRequest.VKey mKeyCache;

    static final String USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) " +
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

    @Override
    public void searchMusicAsync(String keyword, int page, RequestCallback<List<? extends Song>> callback) {
        new QQSearchMusicRequest(keyword).requestAsync(callback);
    }

    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) throws IOException {
        List<? extends Song> result = new QQSearchMusicRequest(keyword).requestSync();
        if (needLink) {
            for (Song song : result) {
                song.setMusicLink(getMusicLinkByIdSync(song.getSongId()));
            }
        }
        return result;
    }

    @Override
    public void getMusicInfoByIdAsync(String musicId, RequestCallback<? extends Song> callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getMusicLinkByIdAsync(final String musicId, final RequestCallback<MusicLink> callback) {
        if (mKeyCache == null) {
            new QQUpdateVKeyRequest().requestAsync(new RequestCallback<QQUpdateVKeyRequest.VKey>() {
                @Override
                public void onFailure(IOException e) {
                    callback.onFailure(e);
                }

                @Override
                public void onSuccess(QQUpdateVKeyRequest.VKey vKeyObj) {
                    mKeyCache = vKeyObj;
                    QQSongLink result = getSongLink(vKeyObj, musicId);
                    callback.onSuccess(result);
                }
            });
        } else {
            // 直接成功
            // TODO: check key expire
            QQSongLink result = getSongLink(mKeyCache, musicId);
            callback.onSuccess(result);
        }
    }

    @Override
    public MusicLink getMusicLinkByIdSync(String musicId) throws IOException {
        if (mKeyCache == null) {
            QQUpdateVKeyRequest.VKey vKey = new QQUpdateVKeyRequest().requestSync();
            mKeyCache = vKey;
        }
        QQSongLink result = getSongLink(mKeyCache, musicId);
        return result;
    }

    private static QQSongLink getSongLink(QQUpdateVKeyRequest.VKey vKeyObj, String musicId) {
        String host = vKeyObj.sips.get(0);
        String vKey = vKeyObj.key;
        final String link = buildQQMusicLink(host, Quality.High, musicId, vKey, GUID);
        QQSongLink result = new QQSongLink();
        result.url = link;
        return result;
    }

    @Override
    public void getMusicLinkByIdsAsync(RequestCallback<List<? extends MusicLink>> callback, String... musicIds) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getAlbumInfoById(RequestCallback<Album> callback, String albumId) {
        throw new UnsupportedOperationException();
    }

    private static String buildQQMusicLink(String host, Quality quality, String mid, String key, String guid) {
        return host + quality.getPrefix() + mid + ".mp3?vkey=" + key + "&guid=" + guid + "&fromtag=1";
    }
}
