package wholemusic.core.provider.xiami;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.model.Artist;
import wholemusic.core.model.BaseBean;

/**
 * Created by haohua on 2018/2/9.
 */
class XiamiSinger extends BaseBean implements Artist {
    @JSONField(name = "artist_name")
    public String artistName;

    @JSONField(name = "artist_id")
    public String artistId;

    @Override
    public String getName() {
        return artistName;
    }

    @Override
    public String getId() {
        return artistId;
    }
}
