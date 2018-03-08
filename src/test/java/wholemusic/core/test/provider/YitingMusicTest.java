package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.impl.SearchMusicTestImpl;

@SuppressWarnings("SpellCheckingInspection")
public class YitingMusicTest extends SearchMusicTestImpl {
    public YitingMusicTest() {
        super(MusicProvider.Yiting, "Beyond");
    }
}
