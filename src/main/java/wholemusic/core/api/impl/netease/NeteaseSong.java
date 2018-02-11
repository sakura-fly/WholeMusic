package wholemusic.core.api.impl.netease;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.model.Artist;
import wholemusic.core.api.model.BaseBean;
import wholemusic.core.api.model.Music;

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
