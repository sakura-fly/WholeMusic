package wholemusic.core.provider.xiami;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.MusicLink;

/**
 * Created by haohua on 2018/2/9.
 */
class XiamiSongLink extends BaseBean implements MusicLink {

    //@JSONField(name = "listen_file")
    public String url;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public String getSongId() {
        return null;
    }

    @Override
    public long getBitRate() {
        return 0;
    }

    @Override
    public String getMd5() {
        return null;
    }
}
