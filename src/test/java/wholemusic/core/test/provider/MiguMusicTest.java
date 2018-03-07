package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.impl.SearchMusicTestImpl;

@SuppressWarnings("SpellCheckingInspection")
public class MiguMusicTest extends SearchMusicTestImpl {
    public MiguMusicTest() {
        super(MusicProvider.Migu, "孙燕姿");
    }
}
