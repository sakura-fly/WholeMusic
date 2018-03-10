package wholemusic.core.test.framework;

import wholemusic.core.api.MusicProvider;

import java.util.Map;

public abstract class MusicTestClassByProvider extends AbsMusicTestClass {
    private final MusicProvider provider;

    public MusicTestClassByProvider(MusicProvider provider) {
        this.provider = provider;
    }

    protected abstract void addSupportedTestCase(SupportedTestCaseBuilder builder);

    @Override
    protected Map<Class<?>, Object[]> getSupportedTestImplementAndArgsMap() {
        SupportedTestCaseBuilder builder = SupportedTestCaseBuilder.create(provider);
        addSupportedTestCase(builder);
        return builder.getSupportedTestsMap();
    }
}
