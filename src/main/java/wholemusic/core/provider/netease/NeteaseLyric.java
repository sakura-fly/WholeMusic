package wholemusic.core.provider.netease;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Lyric;

@SuppressWarnings("SpellCheckingInspection")
class NeteaseLyric extends BaseBean implements Lyric {
    @JSONField(name = "lyric")
    public String lyric;

    @Override
    public String getLyric() {
        return lyric;
    }

    @Override
    public String getLyricUrl() {
        return null;
    }
}
