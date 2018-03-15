package wholemusic.core.test.framework;

import org.junit.Test;
import wholemusic.core.test.framework.mark.GetAlbumTest;
import wholemusic.core.test.framework.mark.GetMusicDetailTest;
import wholemusic.core.test.framework.mark.GetMusicLinkTest;
import wholemusic.core.test.framework.mark.SearchMusicTest;

import java.util.Map;

abstract class AbsMusicTestClass implements SearchMusicTest {
    protected abstract Map<Class<?>, Object[]> getSupportedTestImplementAndArgsMap();

    @Test
    public void searchMusicTest() throws Exception {
        findTestImplAndRun(SearchMusicTest.class);
    }

    @Test
    public void getMusicDetailTest() throws Exception {
        findTestImplAndRun(GetMusicDetailTest.class);
    }

    @Test
    public void getGetAlbumInfoTest() throws Exception {
        findTestImplAndRun(GetAlbumTest.class);
    }

    @Test
    public void getGetMusicLinkTest() throws Exception {
        findTestImplAndRun(GetMusicLinkTest.class);
    }

    private void findTestImplAndRun(Class<?> testInterface) throws Exception {
        boolean foundTest = false;
        Map<Class<?>, Object[]> map = getSupportedTestImplementAndArgsMap();
        for (Map.Entry<Class<?>, Object[]> item : map.entrySet()) {
            Class<?> testImplClass = item.getKey();
            Object[] callArgs = item.getValue();
            if (testInterface.isAssignableFrom(testImplClass)) {
                AbsMusicTestCase impl = (AbsMusicTestCase) testImplClass.newInstance();
                impl.init(callArgs);
                impl.runTest();
                foundTest = true;
                break;
            }
        }
        if (!foundTest) {
            throw new UnsupportedOperationException("temporarily not supported test: " + testInterface.getSimpleName());
        }
    }
}
