package wholemusic.core.provider.xiami;

import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Lyric;

@SuppressWarnings("SpellCheckingInspection")
class XiamiLyric extends BaseBean implements Lyric {
    private String lyricUrl;

    @Override
    public String getLyric() {
        return null;
    }

    @Override
    public String getLyricUrl() {
        return lyricUrl;
    }

    public void setLyricUrl(String lyricUrl) {
        this.lyricUrl = lyricUrl;
    }
}
