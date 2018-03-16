package wholemusic.core.provider.migu;

import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Lyric;

@SuppressWarnings("SpellCheckingInspection")
class MiguLyric extends BaseBean implements Lyric {
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
