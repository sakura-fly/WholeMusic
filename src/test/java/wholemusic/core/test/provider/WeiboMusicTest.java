package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.MusicTestClassByProvider;
import wholemusic.core.test.framework.SupportedTestCaseBuilder;

@SuppressWarnings("SpellCheckingInspection")
public class WeiboMusicTest extends MusicTestClassByProvider {
    public WeiboMusicTest() {
        super(MusicProvider.Weibo);
    }

    @Override
    protected void addSupportedTestCase(SupportedTestCaseBuilder builder) {
        String query = "陈绮贞";
        builder.iCanSearchMusicPleaseTestMeWithQuery(query);
    }
}
