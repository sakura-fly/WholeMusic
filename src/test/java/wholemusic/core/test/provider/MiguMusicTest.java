package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.MusicTestClassByProvider;
import wholemusic.core.test.framework.SupportedTestCaseBuilder;

@SuppressWarnings("SpellCheckingInspection")
public class MiguMusicTest extends MusicTestClassByProvider {
    public MiguMusicTest() {
        super(MusicProvider.Migu);
    }

    @Override
    protected void addSupportedTestCase(SupportedTestCaseBuilder builder) {
        builder.iCanSearchMusicPleaseTestMeWithQuery("孙燕姿");
    }
}
