package wholemusic.core.provider.migu;

import wholemusic.core.api.MusicApi;
import wholemusic.core.model.Album;
import wholemusic.core.model.MusicLink;
import wholemusic.core.model.Song;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
@SuppressWarnings("SpellCheckingInspection")
public class MiguMusicApi implements MusicApi {
    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) throws IOException {
        List<? extends Song> result = new MiguSearchMusicRequest(keyword, page).requestSync();
        return result;
    }

    @Override
    public MusicLink getMusicLinkByIdSync(String musicId) throws IOException {
        return null;
    }

    @Override
    public List<? extends Song> getSongDetailInfoByIdsSync(String... musicIds) throws IOException {
        return null;
    }

    @Override
    public Album getAlbumInfoByIdSync(String albumId, boolean needLink) throws IOException {
        return null;
    }
}
