package wholemusic.core.provider.qq;

import wholemusic.core.model.BaseBean;
import wholemusic.core.model.MusicLink;

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
