package wholemusic.core.provider.kugou;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.model.Artist;
import wholemusic.core.model.BaseBean;

/**
 * Created by haohua on 2018/2/23.
 */

@SuppressWarnings("SpellCheckingInspection")
class KugouArtist extends BaseBean implements Artist {
    @JSONField(name = "name")
    public String name;

    @JSONField(name = "id")
    public String id;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}
