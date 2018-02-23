package wholemusic.core.api;

import wholemusic.core.model.Album;
import wholemusic.core.model.Song;
import wholemusic.core.model.MusicLink;

import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
public class NotFullyImplementedMusicApi implements MusicApi {

    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MusicLink getMusicLinkByIdSync(String musicId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Album getAlbumInfoByIdSync(String albumId, boolean needLink) {
        throw new UnsupportedOperationException();
    }
}
