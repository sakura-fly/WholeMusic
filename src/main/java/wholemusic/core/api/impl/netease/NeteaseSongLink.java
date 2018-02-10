package wholemusic.core.api.impl.netease;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.framework.model.BaseBean;
import wholemusic.core.api.framework.model.Music;
import wholemusic.core.util.Function;

/**
 * Created by haohua on 2018/2/9.
 */
public class NeteaseSongLink extends BaseBean {

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
}
