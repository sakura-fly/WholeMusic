package wholemusic.core.api.impl.qq;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.model.Music;
import wholemusic.core.api.model.MusicLink;

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

    public List<? extends Music> searchMusic(String keyword) throws IOException {
        List<QQSong> result = new QQSearchMusicRequest(keyword).requestSync();
        return result;
    }

    public Music getMusicInfoById(String musicId) throws IOException {
        return null;
    }

    @Override
    public MusicLink getMusicLinkById(String musicId) throws IOException {
        if (mKeyCache == null) {
            mKeyCache = new QQUpdateVKeyRequest().requestSync();
        }
        String host = mKeyCache.sips.get(0);
        String vKey = mKeyCache.key;
        final String link = buildQQMusicLink(host, Quality.High, musicId, vKey, GUID);
        QQSongLink result = new QQSongLink();
        result.url = link;
        return result;
    }

    @Override
    public List<? extends MusicLink> getMusicLinkByIds(String... musicIds) throws IOException {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    private static String buildQQMusicLink(String host, Quality quality, String mid, String key, String guid) {
        return host + quality.getPrefix() + mid + ".mp3?vkey=" + key + "&guid=" + guid + "&fromtag=1";
    }
}
