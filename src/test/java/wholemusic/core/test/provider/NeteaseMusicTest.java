package wholemusic.core.test.provider;

import org.junit.Test;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.GetAlbumTest;
import wholemusic.core.test.framework.GetMusicDetailTest;
import wholemusic.core.test.framework.SearchMusicTest;
import wholemusic.core.test.framework.impl.GetAlbumTestImpl;
import wholemusic.core.test.framework.impl.GetMusicDetailTestImpl;
import wholemusic.core.test.framework.impl.SearchMusicTestImpl;

import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class NeteaseMusicTest implements SearchMusicTest, GetAlbumTest, GetMusicDetailTest {

    private final static MusicProvider provider = MusicProvider.Netease;

    private final static String query = "Suede";

    @Test
    public void searchMusicTest() throws IOException {
        new SearchMusicTestImpl(provider, query).searchMusicTest();
    }

    @Test
    public void getAlbumInfoTest() throws IOException {
        new GetAlbumTestImpl(provider, query).getAlbumInfoTest();
    }

    @Test
    public void getMusicDetailTest() throws Exception {
        new GetMusicDetailTestImpl(provider, query).getMusicDetailTest();
    }
}
