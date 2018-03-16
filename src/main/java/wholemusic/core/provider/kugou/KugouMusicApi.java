package wholemusic.core.provider.kugou;

import wholemusic.core.api.MusicApi;
import wholemusic.core.model.Album;
import wholemusic.core.model.MusicLink;
import wholemusic.core.model.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
@SuppressWarnings("SpellCheckingInspection")
public class KugouMusicApi implements MusicApi {
    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) throws IOException {
        List<KugouSong> result = new KugouSearchMusicRequest(keyword, page).requestSync();
        if (needLink) {
            ArrayList<KugouSong> detailSongs = new ArrayList<>();
            for (KugouSong song : result) {
                KugouSong detail = new KugouGetSongDetailRequest(song.getSongId()).requestSync();
                detail.albumId = song.albumId;
                detail.albumName = song.albumName;
                detailSongs.add(detail);
            }
            result = detailSongs;
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
