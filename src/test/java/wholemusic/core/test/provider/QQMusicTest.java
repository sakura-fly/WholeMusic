package wholemusic.core.test.provider;

import org.junit.Test;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.GetAlbumTest;
import wholemusic.core.test.framework.SearchMusicTest;
import wholemusic.core.test.framework.impl.GetAlbumTestImpl;
import wholemusic.core.test.framework.impl.SearchMusicTestImpl;

import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class QQMusicTest implements SearchMusicTest, GetAlbumTest {

    private final static MusicProvider provider = MusicProvider.QQ;

    private final static String query = "孙燕姿";

    @Test
    public void searchMusicTest() throws IOException {
        new SearchMusicTestImpl(provider, query).searchMusicTest();
    }

    @Test
    public void getAlbumInfoTest() throws IOException {
        new GetAlbumTestImpl(provider, query).getAlbumInfoTest();
    }
}
