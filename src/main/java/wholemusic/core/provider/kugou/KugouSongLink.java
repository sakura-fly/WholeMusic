package wholemusic.core.provider.kugou;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.MusicLink;

/**
 * Created by haohua on 2018/2/23.
 */
@SuppressWarnings("SpellCheckingInspection")
class KugouSongLink extends BaseBean implements MusicLink {

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "bitRate")
    private long bitRate;

    @JSONField(name = "extName")
    private String extName;

    @JSONField(name = "fileSize")
    private long size;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getType() {
        return extName;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String getSongId() {
        return null;
    }

    @Override
    public long getBitRate() {
        return bitRate;
    }

    @Override
    public String getMd5() {
        return null;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
