package wholemusic.core.test.provider;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.MusicTestClassByProvider;
import wholemusic.core.test.framework.SupportedTestCaseBuilder;

@SuppressWarnings("SpellCheckingInspection")
public class NeteaseMusicTest extends MusicTestClassByProvider {
    public NeteaseMusicTest() {
        super(MusicProvider.Netease);
    }

    @Override
    protected void addSupportedTestCase(SupportedTestCaseBuilder builder) {
        final String query = "Suede";
        builder.iCanSearchMusicPleaseTestMeWithQuery(query);
        builder.iCanGetMusicLinkPleaseTestMeWithQuery(query);
        builder.iCanGetAlbumInfoPleaseTestMeWithQuery(query);
        builder.iCanGetMusicDetailPleaseTestMeWithQuery(query);
    }
}
