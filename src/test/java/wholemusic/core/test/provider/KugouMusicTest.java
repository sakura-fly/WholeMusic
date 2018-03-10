package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.MusicTestClassByProvider;
import wholemusic.core.test.framework.SupportedTestCaseBuilder;

@SuppressWarnings("SpellCheckingInspection")
public class KugouMusicTest extends MusicTestClassByProvider {
    public KugouMusicTest() {
        super(MusicProvider.Kugou);
    }

    @Override
    protected void addSupportedTestCase(SupportedTestCaseBuilder builder) {
        builder.iCanSearchMusicPleaseTestMeWithQuery("Beyond");
    }
}
