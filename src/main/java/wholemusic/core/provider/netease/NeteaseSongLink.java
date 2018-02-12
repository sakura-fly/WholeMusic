package wholemusic.core.provider.netease;

import com.alibaba.fastjson.annotation.JSONField;

import wholemusic.core.model.BaseBean;
import wholemusic.core.model.MusicLink;

/**
 * Created by haohua on 2018/2/9.
 */
public class NeteaseSongLink extends BaseBean implements MusicLink {

    @JSONField(name = "url")
    public String url;

    @JSONField(name = "id")
    public long songId;

    @JSONField(name = "size")
    public long size;

    @JSONField(name = "br")
    public long bitrate;

    @JSONField(name = "md5")
    public String md5;
    @JSONField(name = "type")

    public String type;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getType() {
        return type;
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
        return bitrate;
    }

    @Override
    public String getMd5() {
        return md5;
    }
}
