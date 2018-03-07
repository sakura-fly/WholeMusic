package wholemusic.core.test.framework.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.config.Constants;
import wholemusic.core.model.Song;
import wholemusic.core.test.util.TestUtils;
import wholemusic.core.test.framework.SearchMusicTest;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class SearchMusicTestImpl implements SearchMusicTest {

    private final MusicProvider provider;
    private final MusicApi api;
    private final String searchQuery;

    public SearchMusicTestImpl(MusicProvider provider, String searchQuery) {
        this.provider = provider;
        this.searchQuery = searchQuery;
        this.api = MusicApiFactory.create(provider);
    }

    @Test
    public void searchMusicTest() throws IOException {
        List<? extends Song> page0 = api.searchMusicSync(searchQuery, 0, true);
        assertEquals(Constants.PAGE_SIZE, page0.size());
        List<? extends Song> page1 = api.searchMusicSync(searchQuery, 1, true);
        assertEquals(Constants.PAGE_SIZE, page1.size());
        // test download link
        Song page1Song0 = page1.get(0);
        Assert.assertEquals(200, TestUtils.testDownload(page1Song0.getMusicLink().getUrl()));
        // test provider
        assertEquals(this.provider, page1Song0.getMusicProvider());
    }
}
