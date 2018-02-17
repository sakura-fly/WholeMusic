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
    public void searchMusicAsync(String keyword, int page, RequestCallback<List<? extends Song>> callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<? extends Song> searchMusicSync(String keyword, int page, boolean needLink) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getMusicInfoByIdAsync(String musicId, RequestCallback<? extends Song> callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getMusicLinkByIdAsync(String musicId, RequestCallback<MusicLink> callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MusicLink getMusicLinkByIdSync(String musicId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getMusicLinkByIdsAsync(RequestCallback<List<? extends MusicLink>> callback, String... musicIds) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getAlbumInfoByIdAsync(RequestCallback<Album> callback, String albumId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Album getAlbumInfoByIdSync(String albumId) {
        throw new UnsupportedOperationException();
    }
}
