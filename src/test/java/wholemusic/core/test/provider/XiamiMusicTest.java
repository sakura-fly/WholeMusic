package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.impl.SearchMusicTestImpl;

@SuppressWarnings("SpellCheckingInspection")
public class XiamiMusicTest extends SearchMusicTestImpl {
    public XiamiMusicTest() {
        super(MusicProvider.Xiami, "五环之歌");
    }
}
