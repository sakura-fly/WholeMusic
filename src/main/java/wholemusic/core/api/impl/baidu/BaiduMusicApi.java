package wholemusic.core.api.impl.baidu;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.model.Music;
import wholemusic.core.api.model.MusicLink;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
public class BaiduMusicApi implements MusicApi {
    @Override
    public List<? extends Music> searchMusic(String keyword) throws IOException {
        return null;
    }

    @Override
    public Music getMusicInfoById(String musicId) throws IOException {
        return null;
    }

    @Override
    public MusicLink getMusicLinkById(String musicId) throws IOException {
        return null;
    }

    @Override
    public List<? extends MusicLink> getMusicLinkByIds(String... musicIds) throws IOException {
        return null;
    }
}
