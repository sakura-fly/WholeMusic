package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.MusicTestClassByProvider;
import wholemusic.core.test.framework.SupportedTestCaseBuilder;

@SuppressWarnings("SpellCheckingInspection")
public class YitingMusicTest extends MusicTestClassByProvider {
    public YitingMusicTest() {
        super(MusicProvider.Yiting);
    }

    @Override
    protected void addSupportedTestCase(SupportedTestCaseBuilder builder) {
        String query = "Beyond";
        builder.iCanSearchMusicPleaseTestMeWithQuery(query);
        builder.iCanGetMusicDetailPleaseTestMeWithQuery(query);
    }
}
