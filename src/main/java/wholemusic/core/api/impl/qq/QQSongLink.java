package wholemusic.core.api.impl.qq;

import wholemusic.core.api.model.BaseBean;
import wholemusic.core.api.model.MusicLink;

/**
 * Created by haohua on 2018/2/9.
 */
public class QQSongLink extends BaseBean implements MusicLink {

    public String url;

    @Override
    public String getUrl() {
        return url;
    }
}
