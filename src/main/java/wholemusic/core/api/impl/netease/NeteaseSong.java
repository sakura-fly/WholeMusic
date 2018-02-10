package wholemusic.core.api.impl.netease;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.framework.model.BaseBean;
import wholemusic.core.api.framework.model.Music;
import wholemusic.core.util.Function;

/**
 * Created by haohua on 2018/2/9.
 */
public class NeteaseSong extends BaseBean {

    @JSONField(name = "name")
    public String name;

    @JSONField(name = "id")
    public long songId;

    public Music convert() {
        // TODO
        Music music = new Music();
        return music;
    }

    public static Function<NeteaseSong, Music> getConverterFunction() {
        return new Function<NeteaseSong, Music>() {
            @Override
            public Music apply(NeteaseSong qqSong) {
                return qqSong.convert();
            }
        };
    }
}
