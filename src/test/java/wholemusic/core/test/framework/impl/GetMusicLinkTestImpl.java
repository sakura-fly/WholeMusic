package wholemusic.core.test.framework.impl;

import org.junit.Ignore;
import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.MusicLink;
import wholemusic.core.model.Song;
import wholemusic.core.test.framework.AbsMusicTestCase;
import wholemusic.core.test.framework.mark.GetMusicLinkTest;
import wholemusic.core.test.util.TestUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class GetMusicLinkTestImpl extends AbsMusicTestCase implements GetMusicLinkTest {

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
    public void runTest() throws Exception {
        List<? extends Song> songs = api.searchMusicSync(searchQuery, 0, false);
        String songId = songs.get(0).getSongId();
        MusicLink link = api.getMusicLinkByIdSync(songId);
        assertEquals(link.getSongId(), songId);
        String url = link.getUrl();
        println("url: " + url);
        assertEquals(200, TestUtils.testDownload(url));
    }
}
