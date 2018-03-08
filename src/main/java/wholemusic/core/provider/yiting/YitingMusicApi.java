package wholemusic.core.provider.yiting;

import wholemusic.core.api.MusicApi;
import wholemusic.core.model.Album;
import wholemusic.core.model.MusicLink;
import wholemusic.core.model.Song;
import wholemusic.core.util.Function;
import wholemusic.core.util.SongUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/23.
 */
@SuppressWarnings("SpellCheckingInspection")
public class YitingMusicApi implements MusicApi {
    private Function<String[], List<? extends MusicLink>> mGetSongLinksRequestFunction = new Function<String[],
            List<? extends MusicLink>>() {
        @Override
        public List<? extends MusicLink> apply(String[] musicIds) {
            try {
                return new YitingGetMusicLinksRequest(musicIds).requestSync();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) throws IOException {
        List<? extends Song> result = new YitingSearchMusicRequest(keyword, page).requestSync();
        if (needLink) {
            SongUtils.fillSongLinks(result, mGetSongLinksRequestFunction);
        }
        return result;
    }

    @Override
    public MusicLink getMusicLinkByIdSync(String musicId) throws IOException {
        return null;
    }

    @Override
    public List<? extends Song> getSongDetailInfoByIdsSync(boolean needLyric, String... musicIds) throws IOException {
        return null;
    }

    @Override
    public Album getAlbumInfoByIdSync(String albumId, boolean needLink) throws IOException {
        return null;
    }
}
