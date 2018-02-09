package wholemusic.core.api.impl.qqmusic;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.framework.model.BaseBean;
import wholemusic.core.api.framework.model.Music;
import wholemusic.core.util.Function;

import java.util.ArrayList;

/**
 * Created by haohua on 2018/2/9.
 */
public class QQSong extends BaseBean {
    @JSONField(name = "songname")
    public String name;

    @JSONField(name = "songid")
    public String songId;

    @JSONField(name = "songmid")
    public String songMid;

    @JSONField(name = "singer")
    public ArrayList<QQSinger> singers;

    public Music convert() {
        Music music = new Music();
        music.name = this.name;
        music.musicId = this.songMid;
        return music;
    }

    public static Function<QQSong, Music> getConverterFunction() {
        return new Function<QQSong, Music>() {
            @Override
            public Music apply(QQSong qqSong) {
                return qqSong.convert();
            }
        };
    }
}
