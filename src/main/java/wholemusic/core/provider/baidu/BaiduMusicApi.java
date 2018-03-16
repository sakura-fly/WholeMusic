package wholemusic.core.provider.baidu;

import wholemusic.core.api.MusicApi;
import wholemusic.core.model.Album;
import wholemusic.core.model.MusicLink;
import wholemusic.core.model.Song;
import wholemusic.core.util.SongUtils;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class BaiduMusicApi implements MusicApi {
    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) throws IOException {
        List<? extends Song> result = new BaiduSearchMusicRequest(keyword, page).requestSync();
        if (needLink) {
            String[] songIds = SongUtils.getSongIdsFromSongList(result);
            List<BaiduSong> details = new BaiduGetSongDetailsRequest(songIds).requestSync();
            result = details;
        }
        return result;
    }

    @Override
    public MusicLink getMusicLinkByIdSync(String musicId) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<? extends Song> getSongDetailInfoByIdsSync(boolean needLyric, String... musicIds) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Album getAlbumInfoByIdSync(String albumId, boolean needLink) throws IOException {
        BaiduAlbum album = new BaiduGetAlbumInfoRequest(albumId).requestSync();
        return album;
    }
}
