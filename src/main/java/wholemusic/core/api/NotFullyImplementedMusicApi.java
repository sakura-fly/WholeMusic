package wholemusic.core.api;

import wholemusic.core.model.Music;
import wholemusic.core.model.MusicLink;

import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
public class NotFullyImplementedMusicApi implements MusicApi {
    @Override
    public void searchMusicAsync(String keyword, int page, RequestCallback<List<? extends Music>> callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getMusicInfoByIdAsync(String musicId, RequestCallback<? extends Music> callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getMusicLinkByIdAsync(String musicId, RequestCallback<MusicLink> callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getMusicLinkByIdsAsync(RequestCallback<List<? extends MusicLink>> callback, String... musicIds) {
        throw new UnsupportedOperationException();
    }
}
