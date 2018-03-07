package wholemusic.core.provider.baidu;

import wholemusic.core.api.MusicApi;
import wholemusic.core.model.Album;
import wholemusic.core.model.MusicLink;
import wholemusic.core.model.Song;
import wholemusic.core.util.Function;
import wholemusic.core.util.SongUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
@SuppressWarnings("SpellCheckingInspection")
public class BaiduMusicApi implements MusicApi {

    private Function<String[], List<? extends MusicLink>> mGetSongLinksRequestFunction = new Function<String[],
            List<? extends MusicLink>>() {
        @Override
        public List<? extends MusicLink> apply(String[] musicIds) {
            try {
                return new BaiduGetMusicLinksRequest(musicIds).requestSync();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) throws IOException {
        List<? extends Song> result = new BaiduSearchMusicRequest(keyword, page).requestSync();
        if (needLink) {
            SongUtils.fillSongLinks(result, mGetSongLinksRequestFunction);
        }
        return result;
    }

    @Override
    public MusicLink getMusicLinkByIdSync(String musicId) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<? extends Song> getSongDetailInfoByIdsSync(String... musicIds) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Album getAlbumInfoByIdSync(String albumId, boolean needLink) throws IOException {
        throw new UnsupportedOperationException();
    }
}
