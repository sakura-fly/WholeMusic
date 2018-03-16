package wholemusic.core.provider.weibo;

import wholemusic.core.api.MusicApi;
import wholemusic.core.model.Album;
import wholemusic.core.model.MusicLink;
import wholemusic.core.model.Song;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class WeiboMusicApi implements MusicApi {
    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) throws IOException {
        List<? extends Song> songs = new WeiboSearchMusicRequest(keyword, page).requestSync();
        return songs;
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
