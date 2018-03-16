package wholemusic.core.provider.weibo;

import wholemusic.core.model.Artist;
import wholemusic.core.model.BaseBean;

@SuppressWarnings("SpellCheckingInspection")
class WeiboArtist extends BaseBean implements Artist {
    public String name;

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
