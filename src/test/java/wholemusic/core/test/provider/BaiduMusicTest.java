package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.impl.SearchMusicTestImpl;

@SuppressWarnings("SpellCheckingInspection")
public class BaiduMusicTest extends SearchMusicTestImpl {
    public BaiduMusicTest() {
        super(MusicProvider.Baidu, "岳云鹏");
    }
}
