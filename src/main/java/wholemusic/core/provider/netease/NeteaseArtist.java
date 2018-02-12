package wholemusic.core.provider.netease;

import com.alibaba.fastjson.annotation.JSONField;

import wholemusic.core.model.Artist;
import wholemusic.core.model.BaseBean;

/**
 * Created by haohua on 2018/2/12.
 */

public class NeteaseArtist extends BaseBean implements Artist {
    @JSONField(name = "name")
    public String name;

    @JSONField(name = "id")
    public long id;

    @Override
    public String getName() {
        return name;
    }
}
