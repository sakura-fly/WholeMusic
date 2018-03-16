package wholemusic.core.provider.baidu;

import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Lyric;

@SuppressWarnings("SpellCheckingInspection")
class BaiduLyric extends BaseBean implements Lyric {
    public String lyricUrl;

    @Override
    public String getLyric() {
        return null;
    }

    @Override
    public String getLyricUrl() {
        return lyricUrl;
    }
}
