package wholemusic.core.provider.netease;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Lyric;

/**
 * Created by haohua on 2018/2/9.
 */
@SuppressWarnings("SpellCheckingInspection")
class NeteaseLyric extends BaseBean implements Lyric {
    @JSONField(name = "lyric")
    public String lyric;

    @Override
    public String getLyric() {
        return lyric;
    }
}
