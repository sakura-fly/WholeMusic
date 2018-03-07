package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.impl.SearchMusicTestImpl;

@SuppressWarnings("SpellCheckingInspection")
public class KugouMusicTest extends SearchMusicTestImpl {
    public KugouMusicTest() {
        super(MusicProvider.Kugou, "Beyond");
    }
}
