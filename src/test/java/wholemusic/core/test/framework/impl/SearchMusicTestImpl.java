package wholemusic.core.test.framework.impl;

import org.junit.Assert;
import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.config.Constants;
import wholemusic.core.model.Album;
import wholemusic.core.model.Song;
import wholemusic.core.test.framework.AbsMusicTestCase;
import wholemusic.core.test.framework.mark.SearchMusicTest;
import wholemusic.core.test.util.TestUtils;
import wholemusic.core.util.TextUtils;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchMusicTestImpl extends AbsMusicTestCase implements SearchMusicTest {
    private MusicProvider provider;
    private MusicApi api;
    private String searchQuery;

    @Override
    public void init(Object[] args) {
        provider = (MusicProvider) args[0];
        searchQuery = (String) args[1];
        api = MusicApiFactory.create(provider);
    }

    @Override
    public void runTest() throws IOException {
        List<? extends Song> page0 = api.searchMusicSync(searchQuery, 0, true);
        assertEquals(Constants.PAGE_SIZE, page0.size());
        List<? extends Song> page1 = api.searchMusicSync(searchQuery, 1, true);
        assertEquals(Constants.PAGE_SIZE, page1.size());
        // test download link
        Song page1Song0 = page1.get(0);
        println("page1Song0: " + page1Song0);
        String url = page1Song0.getMusicLink().getUrl();
        println("url: " + url);
        String cover = page1Song0.getPicUrl();
        if (TextUtils.isEmpty(cover)) {
            errPrintln("cover is empty: " + cover);
        } else {
            println("cover: " + cover);
        }
        String songId = page1Song0.getSongId();
        Assert.assertTrue(!TextUtils.isEmpty(songId));
        Assert.assertTrue(!"0".equals(songId));
        Assert.assertTrue(!"1".equals(songId));

        Album album = page1Song0.getAlbum();
        if (album == null) {
            errPrintln("warning: album is null!");
        } else {
            String albumName = album.getName();
            if (TextUtils.isEmpty(albumName)) {
                errPrintln("warning: album name is empty: " + albumName);
            }
        }
        Assert.assertEquals(200, TestUtils.testDownload(url));
        // test provider
        assertEquals(this.provider, page1Song0.getMusicProvider());
    }
}
