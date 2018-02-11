package wholemusic.core.provider.netease;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.model.Artist;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Music;

import java.util.List;

/**
 * Created by haohua on 2018/2/9.
 */
public class NeteaseSong extends BaseBean implements Music {

    @JSONField(name = "name")
    public String name;

    @JSONField(name = "id")
    public long songId;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMusicId() {
        return String.valueOf(songId);
    }

    @Override
    public List<? extends Artist> getArtists() {
        // TODO
        return null;
    }
}
