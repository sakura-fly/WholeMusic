package wholemusic.core.provider.netease;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.model.Album;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Song;

import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
public class NeteaseAlbum extends BaseBean implements Album {

    @JSONField(name = "name")
    public String name;

    @JSONField(name = "id")
    public long id;

    public List<NeteaseSong> songs;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAlbumId() {
        return String.valueOf(id);
    }

    @Override
    public List<? extends Song> getSongs() {
        return songs;
    }
}
