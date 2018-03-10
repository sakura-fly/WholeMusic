package wholemusic.core.test.framework;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.test.framework.impl.GetAlbumTestImpl;
import wholemusic.core.test.framework.impl.GetMusicDetailTestImpl;
import wholemusic.core.test.framework.impl.GetMusicLinkTestImpl;
import wholemusic.core.test.framework.impl.SearchMusicTestImpl;

import java.util.HashMap;
import java.util.Map;

public class SupportedTestCaseBuilder {
    private final MusicProvider provider;
    private Map<Class<?>, Object[]> supportedTestsMap = new HashMap<>();

    private SupportedTestCaseBuilder(MusicProvider provider) {
        this.provider = provider;
    }

    public static SupportedTestCaseBuilder create(MusicProvider provider) {
        return new SupportedTestCaseBuilder(provider);
    }

    public SupportedTestCaseBuilder iCanSearchMusicPleaseTestMeWithQuery(String query) {
        supportedTestsMap.put(SearchMusicTestImpl.class, new Object[]{provider, query});
        return this;
    }

    public SupportedTestCaseBuilder iCanGetMusicLinkPleaseTestMeWithQuery(String query) {
        supportedTestsMap.put(GetMusicLinkTestImpl.class, new Object[]{provider, query});
        return this;
    }

    public SupportedTestCaseBuilder iCanGetMusicDetailPleaseTestMeWithQuery(String query) {
        supportedTestsMap.put(GetMusicDetailTestImpl.class, new Object[]{provider, query});
        return this;
    }

    public SupportedTestCaseBuilder iCanGetAlbumInfoPleaseTestMeWithQuery(String query) {
        supportedTestsMap.put(GetAlbumTestImpl.class, new Object[]{provider, query});
        return this;
    }

    Map<Class<?>, Object[]> getSupportedTestsMap() {
        return supportedTestsMap;
    }
}
