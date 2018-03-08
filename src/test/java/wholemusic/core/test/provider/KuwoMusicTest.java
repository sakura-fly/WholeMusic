package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.impl.SearchMusicTestImpl;

@SuppressWarnings("SpellCheckingInspection")
public class KuwoMusicTest extends SearchMusicTestImpl {
    public KuwoMusicTest() {
        super(MusicProvider.Kuwo, "Beyond");
    }
}
