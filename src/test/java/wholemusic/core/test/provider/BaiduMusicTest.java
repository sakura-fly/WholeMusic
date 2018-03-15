package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.MusicTestClassByProvider;
import wholemusic.core.test.framework.SupportedTestCaseBuilder;

@SuppressWarnings("SpellCheckingInspection")
public class BaiduMusicTest extends MusicTestClassByProvider {
    public BaiduMusicTest() {
        super(MusicProvider.Baidu);
    }

    @Override
    protected void addSupportedTestCase(SupportedTestCaseBuilder builder) {
        String query = "陈奕迅";
        builder.iCanSearchMusicPleaseTestMeWithQuery(query);
        builder.iCanGetAlbumInfoPleaseTestMeWithQuery(query);
    }
}
