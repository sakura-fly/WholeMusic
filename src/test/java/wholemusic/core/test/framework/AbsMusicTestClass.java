package wholemusic.core.test.framework;

import org.junit.Test;
import wholemusic.core.test.framework.mark.SearchMusicTest;

import java.util.Map;

abstract class AbsMusicTestClass implements SearchMusicTest {
    protected abstract Map<Class<?>, Object[]> getSupportedTestImplementAndArgsMap();

    @Test
    public void searchMusicTest() throws Exception {
        findTestImplAndRun(SearchMusicTest.class);
    }

    private void findTestImplAndRun(Class<?> testInterface) throws Exception {
        Map<Class<?>, Object[]> map = getSupportedTestImplementAndArgsMap();
        for (Map.Entry<Class<?>, Object[]> item : map.entrySet()) {
            Class<?> testImplClass = item.getKey();
            Object[] callArgs = item.getValue();
            if (testInterface.isAssignableFrom(testImplClass)) {
                AbsMusicTestCase impl = (AbsMusicTestCase) testImplClass.newInstance();
                impl.init(callArgs);
                impl.runTest();
                break;
            }
        }
    }
}
