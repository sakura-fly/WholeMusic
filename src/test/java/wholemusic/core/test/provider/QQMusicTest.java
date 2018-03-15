package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.MusicTestClassByProvider;
import wholemusic.core.test.framework.SupportedTestCaseBuilder;

@SuppressWarnings("SpellCheckingInspection")
public class QQMusicTest extends MusicTestClassByProvider {
    public QQMusicTest() {
        super(MusicProvider.QQ);
    }

    @Override
    protected void addSupportedTestCase(SupportedTestCaseBuilder builder) {
        String query = "孙燕姿";
        builder.iCanSearchMusicPleaseTestMeWithQuery(query);
        builder.iCanGetAlbumInfoPleaseTestMeWithQuery(query);
    }
}
