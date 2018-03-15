package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.MusicTestClassByProvider;
import wholemusic.core.test.framework.SupportedTestCaseBuilder;

@SuppressWarnings("SpellCheckingInspection")
public class XiamiMusicTest extends MusicTestClassByProvider {
    public XiamiMusicTest() {
        super(MusicProvider.Xiami);
    }

    @Override
    protected void addSupportedTestCase(SupportedTestCaseBuilder builder) {
        String query = "五环之歌";
        builder.iCanSearchMusicPleaseTestMeWithQuery(query);
    }
}
