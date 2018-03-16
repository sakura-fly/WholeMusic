package wholemusic.core.provider.baidu;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.MusicLink;

/**
 * Created by haohua on 2018/2/9.
 */
@SuppressWarnings("SpellCheckingInspection")
class BaiduSongLink extends BaseBean implements MusicLink {

    @JSONField(name = "songLink")
    public String url;

    @JSONField(name = "songId")
    public long songId;

    @JSONField(name = "size")
    public long size;

    @JSONField(name = "rate")
    public long bitrate;

    @JSONField(name = "format")
    public String format;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getType() {
        return format;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String getSongId() {
        return String.valueOf(songId);
    }

    @Override
    public long getBitRate() {
        return bitrate * 1000;
    }

    @Override
    public String getMd5() {
        // TODO
        return null;
    }
}
